package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.FigureDict;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
public interface FigureDictMapper extends BaseMapper<FigureDict> {
    List<FigureDict> findAllFigureDict();

    List<FigureDict> findFigureDictByLevel(Integer level);
}
