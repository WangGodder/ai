package com.swu.ai.dao.Impl;

import com.swu.ai.dao.FigureWeightDao;
import com.swu.ai.entity.FigureWeight;
import com.swu.ai.mapper.FigureWeightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: godder
 * @date: 2019/3/11
 */
@Repository
public class FigureWeightDaoImpl implements FigureWeightDao {
    @Autowired
    private FigureWeightMapper figureWeightMapper;

    @Override
    public FigureWeight getFigureWeight(Long id) {
        return figureWeightMapper.getFigureWeight(id);
    }

    @Override
    public boolean addFigureWeight(FigureWeight figureWeight) {
        return figureWeightMapper.addFigureWeight(figureWeight);
    }
}
