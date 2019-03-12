package com.swu.ai.dao.Impl;

import com.swu.ai.dao.EvaluateResultDao;
import com.swu.ai.entity.EvaluateResult;
import com.swu.ai.mapper.EvaluateResultMapper;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.request.EvaluateResultReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/12
 */
@Repository
public class EvaluateResultDaoImpl implements EvaluateResultDao {
    @Autowired
    private EvaluateResultMapper evaluateResultMapper;

    @Override
    public List<EvaluateResult> findAllEvaluateResult() {
        return evaluateResultMapper.findAllEvaluateResult();
    }

    @Override
    public List<EvaluateResult> findEvaluateResultByReq(EvaluateResultReq req) {
        return evaluateResultMapper.findEvaluateResultByReq(req);
    }

    @Override
    public boolean addEvaluateResult(EvaluateResult evaluateResult) {
        return evaluateResultMapper.addEvaluateResult(evaluateResult);
    }

    @Override
    public boolean updateEvaluateResult(EvaluateResult evaluateResult) {
        return evaluateResultMapper.updateEvaluateResult(evaluateResult);
    }

}
