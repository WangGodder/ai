package com.swu.ai.service.Impl;

import com.swu.ai.dao.CompanyInputDao;
import com.swu.ai.dao.FingerDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.EvaluateResult;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.request.CompanyFigureReq;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.service.FingerService;
import com.swu.ai.vo.VoFingerResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private FingerDao fingerDao;
    @Resource
    private CompanyInputDao companyInputDaoDao;

    @Override
    public List<FingerResultV0> getFingerResult(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate){
        return fingerDao.findAllResultByCondition(year, periodType, denominatorType, companyId, companyPlate);
    }

    @Override
    public List<VoFingerResult> getFingerResultSum2(CompanyFigureReq companyInput){
        return companyInputDaoDao.findSumAllByYearAndQuarter(companyInput);
    }

    @Override
    public List<VoFingerResult> getFingerResultMax2(CompanyFigureReq companyInput){
        return companyInputDaoDao.findMaxAllByYearAndQuarter(companyInput);
    }

    @Override
    public List<EvaluateResult> evaluateCompany(CompanyInputReq companyInputReq) {
        return null;
    }

    /**
     * 根据CompanyInputReq和计算方式生成针对于当前时间的无重复ID, 作为redis的key值
     * @param companyInputReq
     * @param calcType
     * @return
     */
    private String calcIdByCompanyInputReq(CompanyInputReq companyInputReq, int calcType) {
        StringBuilder sb = new StringBuilder();
        sb.append(calcType);
        sb.append(companyInputReq.getIndustry() == null  || companyInputReq.getIndustry().isEmpty() ? " " : companyInputReq.getIndustry());
        sb.append(companyInputReq.getBeginYear() == null ? "0000" : companyInputReq.getBeginYear());
        sb.append(companyInputReq.getEndYear() == null ? "0000" : companyInputReq.getEndYear());
        sb.append(companyInputReq.getRegion() == null || companyInputReq.getRegion().isEmpty() ? " " : companyInputReq.getRegion());
        sb.append(companyInputReq.getBeginQuarter() == null ? "0" : companyInputReq.getBeginQuarter());
        sb.append(companyInputReq.getEndYear() == null ? "0" : companyInputReq.getEndQuarter());
        return sb.toString();
    }

    /**
     * 根据请求获取CompanyInput,并分别求出均值、最大值、最小值、四分位数等结果
     * @param req 评估范围的请求
     * @return 按照
     */
    private List<CompanyInput> calcBase(CompanyInputReq req) {

        return null;
    }

    /**
     * 根据基数进行评估，返回输入公司数据的最低级指标的评估结果
     * @param companyInput 被评估公司的录入数据
     * @param base 得分相除数据的基数(需要通过其他函数获取，并计算)
     * @return 包含最低级指标的评估结果 （不含高级指标，请调用EvaluateResult.evaluate方法获取完整评估结果）
     */
    private EvaluateResult evaluteFigure(CompanyInput companyInput, CompanyInput base) {
        EvaluateResult result = new EvaluateResult();
        result.setCompanyId(companyInput.getId());
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
