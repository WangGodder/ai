package com.swu.ai.dao;

import com.swu.ai.entity.CompanyInputDict;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
public interface CompanyInputDictDao {
    List<CompanyInputDict> findAllCompanyInputDict();
}
