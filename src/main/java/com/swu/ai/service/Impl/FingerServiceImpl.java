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
//        return null;
    }

    @Override
    public List<VoFingerResult> getFingerResultMax2(CompanyFigureReq companyInput){
        return companyInputDaoDao.findMaxAllByYearAndQuarter(companyInput);
//        return null;
    }

    @Override
    public List<EvaluateResult> evaluateCompany(CompanyInputReq companyInputReq) {
        return null;
    }

    /**
     * 根据基数进行评估，返回输入公司数据的最低级指标的评估结果
     * @param companyInput 被评估公司的录入数据
     * @param base 得分相除数据的基数
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

        return result;
    }
}
