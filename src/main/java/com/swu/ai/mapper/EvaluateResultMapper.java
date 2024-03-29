package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.EvaluateResult;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.request.EvaluateResultReq;

import java.util.List;

public interface EvaluateResultMapper extends BaseMapper<EvaluateResult> {
    List<EvaluateResult> findAllEvaluateResult();

    List<EvaluateResult> findEvaluateResultByReq(EvaluateResultReq evaluateResultReq);

    boolean addEvaluateResult(EvaluateResult evaluateResult);

    boolean updateEvaluateResult(EvaluateResult evaluateResult);

}