package com.swu.ai.service.Impl;

import com.alibaba.fastjson.JSON;
import com.swu.ai.dao.CompanyInputDao;
import com.swu.ai.dao.EvaluateResultDao;
import com.swu.ai.dao.FingerDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.EvaluateResult;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.request.CompanyFigureReq;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.request.EvaluateResultReq;
import com.swu.ai.service.FingerService;
import com.swu.ai.vo.VoFingerResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:47
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
@Service
public class FingerServiceImpl implements FingerService {
    /**
     * 指标计算方法
     */
    public static final int AVG = 0;            // 平均数
    public static final int MAX = 1;            // 最大值
    public static final int MIN = 2;            // 最小值
    public static final int FIRST_QUARTILE = 3; // 第一分位数
    public static final int MEDIAN = 4;         // 中位数
    public static final int THIRD_QUARTILE = 5; // 第三分位数
    @Value(value = "${evaluation.result.indate}")
    public static int RESULT_INDATE;            // 计算数据有效期，如果获取的计算结果超过有效期则重新计算 单位 小时

    @Resource
    private FingerDao fingerDao;
    @Resource
    private CompanyInputDao companyInputDao;
    @Resource
    private EvaluateResultDao evaluateResultDao;
    @Resource
    private com.swu.ai.util.RedisUtil redisUtil;

    @Override
    public List<FingerResultV0> getFingerResult(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate){
        return fingerDao.findAllResultByCondition(year, periodType, denominatorType, companyId, companyPlate);
    }

    @Override
    public List<VoFingerResult> getFingerResultSum2(CompanyFigureReq companyInput){
        return companyInputDao.findSumAllByYearAndQuarter(companyInput);
    }

    @Override
    public List<VoFingerResult> getFingerResultMax2(CompanyFigureReq companyInput){
        return companyInputDao.findMaxAllByYearAndQuarter(companyInput);
    }

    @Override
    public List<EvaluateResult> evaluateCompany(EvaluateResultReq req) {
        // 查找数据库内是否有存放的已算出结果
        List<EvaluateResult> results = evaluateResultDao.findEvaluateResultByReq(req);
        if (results != null && results.size() > 0) {
            // 判断获取数据是否在有效期内
            if (System.currentTimeMillis() - results.get(0).getEvaluateDate().getTime() < RESULT_INDATE) {
                return results;
            }
        }
        // 计算结果
        // 获取范围内所有的数据
        List<CompanyInput> companyInputs = companyInputDao.findCompanyInputSumByReq(req);
        // 从reids上寻找基数
        String keyRedisBase = calcIdByCompanyInputReq(req);
        CompanyInput base = JSON.parseObject(redisUtil.get(keyRedisBase), CompanyInput.class);
        return null;
    }

    /**
     * 根据EvaluateResultReq和计算方式生成针对于当前时间的无重复ID, 作为redis的key值
     * @param req
     * @return
     */
    private String calcIdByCompanyInputReq(EvaluateResultReq req) {
        StringBuilder sb = new StringBuilder();
        sb.append(req.getEvaluateType());
        sb.append(req.getIndustry() == null  || req.getIndustry().isEmpty() ? " " : req.getIndustry());
        sb.append(req.getBeginYear() == null ? "0000" : req.getBeginYear());
        sb.append(req.getEndYear() == null ? "0000" : req.getEndYear());
        sb.append(req.getRegion() == null || req.getRegion().isEmpty() ? " " : req.getRegion());
        sb.append(req.getBeginQuarter() == null ? "0" : req.getBeginQuarter());
        sb.append(req.getEndYear() == null ? "0" : req.getEndQuarter());
        return sb.toString();
    }

    /**
     * 根据请求获取CompanyInput,并分别求出均值、最大值、最小值、四分位数等结果
     * @param req 评估范围的请求
     * @return 按照均值、最大值、最小值、1分位、中位、3分位返回
     */
    private List<CompanyInput> calcBase(CompanyInputReq req) {
        List<CompanyInput> list = new ArrayList<>(6);
        for (int i = 0; i < list.size(); i++) {
            list.add(new CompanyInput());
        }
        Field[] fields = CompanyInput.class.getDeclaredFields();
        List<CompanyInput> companyInputs = companyInputDao.findCompanyInputByReq(req);
        int index = 0;
        for (CompanyInput companyInput : companyInputs) {
            for (int i = 6; i <fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                try {
                    Object read = field.get(companyInput);
                    // first-quartile
                    if (index == companyInputs.size() / 4 - 1) {
                        field.set(list.get(3), read);
                    }
                    // median
                    if (index == companyInputs.size() / 2 - 1) {
                        field.set(list.get(4), read);
                    }
                    // third-quartile
                    if (index == companyInputs.size() / 4 * 3 - 1) {
                        field.set(list.get(5), read);
                    }
                    // type classify
                    if (field.getGenericType() == Integer.class) {
                        // sum
                        field.set(list.get(0), (int)field.get(list.get(0)) + (int)read);
                        // max
                        if ((int)field.get(list.get(1)) < (int)read) {
                            field.set(list.get(1), read);
                        }
                        // min
                        if ((int)field.get(list.get(2)) > (int)read) {
                            field.set(list.get(2), read);
                        }
                    }
                    else if (field.getGenericType() == Double.class) {
                        // sum
                        field.set(list.get(0), (double)field.get(list.get(0)) + (double)read);
                        // max
                        if ((double)field.get(list.get(1)) < (double)read) {
                            field.set(list.get(1), read);
                        }
                        // min
                        if ((double)field.get(list.get(2)) > (double)read) {
                            field.set(list.get(2), read);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            index++;
        }
        // avg
        for (int i = 6; i < fields.length; i++) {
            Field field = fields[i];
            try {
                if (field.getGenericType() == Integer.class) {
                    field.set(list.get(0), (int)field.get(list.get(0)) / companyInputs.size());
                } else if (field.getGenericType() == Double.class) {
                    field.set(list.get(0), (double)field.get(list.get(0)) / companyInputs.size());
                }
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 根据基数进行评估，返回输入公司数据的最低级指标的评估结果
     * @param companyInput 被评估公司的录入数据
     * @param base 得分相除数据的基数(需要通过其他函数获取，并计算)
     * @return 包含最低级指标的评估结果 （不含高级指标，请调用EvaluateResult.evaluate方法获取完整评估结果）
     */
    private EvaluateResult evaluteFigure(CompanyInput companyInput, CompanyInput base) {
        EvaluateResult result = new EvaluateResult();
        result.setCompanyName(companyInput.getCompanyname());
        // 二级指标：已开票的收入
        result.setFigureSaleInvoiceSoft(companyInput.getTicketincomesoftware() / base.getTicketincomesoftware());
        result.setFigureSaleInvoiceHard(companyInput.getTicketincomehardware() / base.getTicketincomehardware());
        result.setFigureSaleInvoiceConsultation(companyInput.getTicketincomeconsult() / base.getTicketincomeconsult());
        result.setFigureSaleInvoiceOther(companyInput.getTicketincomeother() / base.getTicketincomeother());
        // 二级指标：合同收入
        result.setFigureSaleContractSoft(companyInput.getContractincomesoftware() / base.getContractincomesoftware());
        result.setFigureSaleContractHard(companyInput.getContractincomehardware() / base.getContractincomehardware());
        result.setFigureSaleContractConsultation(companyInput.getContractincomeconsult() / base.getContractincomeconsult());
        result.setFigureSaleContractOther(companyInput.getContractincomeother() / base.getContractincomeother());
        // 二级指标：企业所得税
        result.setFigureTaxCorporateRelief(companyInput.getIncometaxdeduction() / base.getIncometaxdeduction());
        result.setFigureTaxCorporateTaxable(companyInput.getIncometaxable() / base.getIncometaxable());
        // 二级指标：个人所得税
        result.setFigureTaxIndividualRelief(companyInput.getPensonaltaxdecution() / base.getPensonaltaxdecution());
        result.setFigureTaxIndividualTaxable(companyInput.getPensonaltaxable() / base.getPensonaltaxable());
        // 二级指标：附加税
        result.setFigureTaxAddedRelief(companyInput.getAddvaluetaxdecution() / base.getAddvaluetaxdecution());
        result.setFigureTaxAddedTaxable(companyInput.getAddvaluetaxable() / base.getAddvaluetaxable());
        // 二级指标：股权类融资
        result.setFigureFinanceStockRisk(companyInput.getStockfinancevc() / base.getStockfinancevc());
        result.setFigureFinanceStockGov(companyInput.getStockfinancegovenment() / base.getStockfinancegovenment());
        result.setFigureFinanceStockPerson(companyInput.getStockfinancepensonal() / base.getStockfinancepensonal());
        // 二级指标：债务类融资
        result.setFigureFinanceDebtBank(companyInput.getDebtfinancebank() / base.getDebtfinancebank());
        result.setFigureFinanceDebtNew(companyInput.getDebtfinanceli() / base.getDebtfinanceli());
        result.setFigureFinanceDebtLending(companyInput.getDebtfinancecompany() / base.getDebtfinancecompany());
        result.setFigureFinanceDebtPerson(companyInput.getDebtfinancepensonal() / base.getDebtfinancepensonal());
        // 二级指标：净资产
        result.setFigureValuationAssetsCirculating(companyInput.getCurrentasset() / base.getCurrentasset());
        result.setFigureValuationAssetsUncirculating(companyInput.getNocurrentasset() / base.getNocurrentasset());
        result.setFigureValuationAssetsDebtCirculating(companyInput.getCurrentdebt() / base.getCurrentdebt());
        result.setFigureValuationAssetsDebtUncirculating(companyInput.getNocurrentdebt() / base.getNocurrentdebt());
        // 二级指标：实际 估计值
        result.setFigureValuationActualFirst(companyInput.getFirstfinancevalue() / base.getFirstfinancevalue());
        result.setFigureValuationActualLatest(companyInput.getLastfinancevalue() / base.getLastfinancevalue());
        result.setFigureValuationActualWant(companyInput.getCurrentfinancevalue() / base.getCurrentfinancevalue());
        // 二级指标：兼职员工数
        result.setFigureHrPartimeDev((double)companyInput.getParttimedevelopment() / (double)base.getParttimedevelopment());
        result.setFigureHrPartimeManage((double) companyInput.getParttimemanager() / (double) base.getParttimemanager());
        result.setFigureHrPartimeAdmin((double) companyInput.getParttimeadmin() / (double) base.getParttimeadmin());
        result.setFigureHrPartimeSaler((double) companyInput.getParttimesell() / (double) base.getParttimesell());
        // 二级指标：全职员工
        result.setFigureHrFulltimeDev((double) companyInput.getDevelopment() / (double) base.getDevelopment());
        result.setFigureHrFulltimeSenior((double) companyInput.getManamger() / (double) base.getManamger());
        result.setFigureHrFulltimeAdmin((double) companyInput.getAdministrator() / (double) base.getAdministrator());
        result.setFigureHrPartimeSaler((double) companyInput.getSell() / (double) base.getSell());
        // 二级指标：高学历员工
        result.setFigureHrEducatedDoc((double) companyInput.getDoctor() / (double) base.getDoctor());
        result.setFigureHrEducatedMaster((double) companyInput.getMaster() / (double) base.getMaster());
        result.setFigureHrBachelor((double) companyInput.getBachelor() / (double) base.getBachelor());
        // 二级指标：申请专利
        result.setFigureInnovatePatentGrantInvention((double) companyInput.getApplypatentinvent() / (double) base.getApplypatentinvent());
        result.setFigureInnovatePatentApplyUtility((double) companyInput.getApplypatentindustry() / (double) base.getApplypatentindustry());
        result.setFigureInnovatePatentApplyAppear((double) companyInput.getApplypatentdesign() / (double) base.getApplypatentdesign());
        // 二级指标：授权专利
        result.setFigureInnovatePatentGrantInvention((double) companyInput.getPatentinvent() / (double) base.getPatentinvent());
        result.setFigureInnovatePatentGrantUtility((double) companyInput.getPatentindustry() / (double) base.getPatentindustry());
        result.setFigureInnovatePatentGrantAppear((double) companyInput.getPatentdesign() / (double) base.getPatentdesign());
        // 二级指标：申请著作权
        result.setFigureInnovateCopyrightApplySoft((double) companyInput.getApplyauthorsoftware() / (double) base.getApplyauthorother());
        result.setFigureInnovateCopyrightApplyUnsoft((double) companyInput.getApplyauthorother() / (double) base.getApplyauthorother());
        // 二级指标：授权著作权
        result.setFigureInnovateCopyrightGrantSoft((double) companyInput.getAuthorsoftware() / (double) base.getAuthorsoftware());
        result.setFigureInnovateCopyrightGrantUnsoft((double) companyInput.getAuthorother() / (double) base.getAuthorother());
        // 二级指标：新服务
        result.setFigureInnovateNewProductPatent((double) companyInput.getServicepatent() / (double) base.getServicepatent());
        result.setFigureInnovateNewProductTech((double) companyInput.getServiceskill() / (double) base.getServiceskill());
        result.setFigureInnovateNewProductBus((double) companyInput.getServicesell() / (double) base.getServicesell());
        // 二级指标：员工工资额
        result.setFigureSalaryStaffUp10(companyInput.getSalaryhigh() / base.getSalaryhigh());
        result.setFigureSalaryStaff510(companyInput.getSalarymiddle() / base.getSalarymiddle());
        result.setFigureSalaryStaffDown5(companyInput.getSalarylow() / base.getSalarylow());
        // 二级指标：员工贡献率
        result.setFigureSalaryStaffContributionMeansale(companyInput.getPersell() / base.getPersell());
        result.setFigureSalaryStaffContributionMeantax(companyInput.getPertax() / base.getPertax());
        // 二级指标：参加培训的次数
        result.setFigureLearnTrainManage((double)companyInput.getTrainmanage() / (double)base.getTrainmanage());
        result.setFigureLearnTrainPolicy((double) companyInput.getTrainlegal() / (double) base.getTrainlegal());
        result.setFigureLearnTrainSkill((double) companyInput.getTrainskill() / (double) base.getTrainskill());
        // 二级指标：参加咨询的次数
        result.setFigureLearnConsltedManage((double) companyInput.getConsultmanage() / (double) base.getConsultmanage());
        result.setFigureLearnConsltedPolicy((double) companyInput.getConsultlegal() / (double) base.getConsultlegal());
        result.setFigureLearnConsltedSkill((double) companyInput.getConsultskill() / (double) base.getConsultskill());
        // 二级指标：企业获奖
        result.setFigureBrandRewardArea((double) companyInput.getAwarddistrict() / (double) base.getAwarddistrict());
        result.setFigureBrandRecognitionCity((double) companyInput.getAwardcity() / (double) base.getAwardcity());
        result.setFigureBrandRewardProvince((double) companyInput.getAwardprovince() / (double) base.getAwardprovince());
        result.setFigureBrandRewardCountry((double) companyInput.getAwardnation() / (double) base.getAwardnation());
        // 二级指标：企业认定
        result.setFigureBrandRecognitionArea((double) companyInput.getComfirmdistrict() / (double) base.getComfirmdistrict());
        result.setFigureBrandRecognitionCity((double) companyInput.getComfirmcity() / (double) base.getComfirmcity());
        result.setFigureBrandRecognitionProvince((double) companyInput.getComfirmprovince() / (double) base.getComfirmprovince());
        result.setFigureBrandRecognitionCountry((double) companyInput.getComfirmnation() / (double) base.getComfirmnation());
        // 二级指标：人才资助
        result.setFigureBrandTalentArea((double) companyInput.getSupportdistrict() / (double) base.getSupportdistrict());
        result.setFigureBrandTalentCity((double) companyInput.getSupportcity() / (double) base.getSupportcity());
        result.setFigureBrandTalentProvince((double) companyInput.getSupportprovince() / (double) base.getSupportprovince());
        result.setFigureBrandTalentCountry((double) companyInput.getSupportnation() / (double) base.getSupportnation());
        return result;
    }
}
