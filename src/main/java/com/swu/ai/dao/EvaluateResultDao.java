package com.swu.ai.dao;

import com.swu.ai.entity.EvaluateResult;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.request.EvaluateResultReq;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/12
 */
public interface EvaluateResultDao {
    List<EvaluateResult> findAllEvaluateResult();

    List<EvaluateResult> findEvaluateResultByReq(EvaluateResultReq req);

    boolean addEvaluateResult(EvaluateResult evaluateResult);

    boolean updateEvaluateResult(EvaluateResult evaluateResult);
}
