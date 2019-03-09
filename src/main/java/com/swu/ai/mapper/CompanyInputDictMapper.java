package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.CompanyInputDict;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
public interface CompanyInputDictMapper extends BaseMapper<CompanyInputDict> {
    List<CompanyInputDict> findAllCompanyInputDict();
}
