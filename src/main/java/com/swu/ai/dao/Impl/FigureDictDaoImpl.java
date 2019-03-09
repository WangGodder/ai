package com.swu.ai.dao.Impl;

import com.swu.ai.dao.FigureDictDao;
import com.swu.ai.entity.FigureDict;
import com.swu.ai.mapper.FigureDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
@Repository
public class FigureDictDaoImpl implements FigureDictDao {
    @Autowired
    private FigureDictMapper figureDictMapper;

    @Override
    public List<FigureDict> findAllFigureDict() {
        return figureDictMapper.findAllFigureDict();
    }

    @Override
    public List<FigureDict> findFigureDictByLevel(int level) {
        return figureDictMapper.findFigureDictByLevel(level);
    }
}
