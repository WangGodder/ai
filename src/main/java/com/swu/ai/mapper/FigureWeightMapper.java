package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.FigureWeight;

public interface FigureWeightMapper extends BaseMapper<FigureWeight> {
    FigureWeight getFigureWeight(Long id);

    boolean addFigureWeight(FigureWeight figureWeight);
}