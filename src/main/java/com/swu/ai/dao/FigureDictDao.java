package com.swu.ai.dao;

import com.swu.ai.entity.FigureDict;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
public interface FigureDictDao {
    List<FigureDict> findAllFigureDict();
    List<FigureDict> findFigureDictByLevel(int level);
}
