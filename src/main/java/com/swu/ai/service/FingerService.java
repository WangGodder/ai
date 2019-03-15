package com.swu.ai.service;

import com.swu.ai.Result.BaseData;
import com.swu.ai.Result.EvaluateDetailTable;
import com.swu.ai.Result.TreeData;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.EvaluateResult;
import com.swu.ai.entity.FigureWeight;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.request.ChartReq;
import com.swu.ai.request.CompanyFigureReq;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.request.EvaluateResultReq;
import com.swu.ai.vo.VoFingerResult;

import java.util.List;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:46
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
public interface FingerService {
    /*
    company_id 公司ID -1表示所有
    companyPlate 公司所属板块 默认是所有板块 all
    year 年份 默认是 2018
    period_type 全年还是季度 ： Y整年 Q1 一季度 Q2 二季度 Q3三季度 Q4四季度 默认是 Y
    denominator_type 分母类型：mean平均值，max最大值，min最小值，极差值range 这一项是必选，默认是mean
    */
    List<FingerResultV0> getFingerResult(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate);

    List<VoFingerResult> getFingerResultSum2(CompanyFigureReq companyInput);

    List<VoFingerResult> getFingerResultMax2(CompanyFigureReq companyInput);

    List<EvaluateResult> evaluateCompany(EvaluateResultReq req);

    List<Map<String, Object>> evaluateCompanyTotal(EvaluateResultReq req);

    EvaluateDetailTable getEvaluateDetailTable();

    List<TreeData<String>> getFigureWeightTree();

    BaseData<Number> baseDataTime(ChartReq req);

    BaseData<Number> baseDataTotal(EvaluateResultReq req);

    boolean addFigureWeight(FigureWeight figureWeight);

}
