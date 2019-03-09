package com.swu.ai.dao.Impl;

import com.swu.ai.dao.CompanyInputDictDao;
import com.swu.ai.entity.CompanyInputDict;
import com.swu.ai.mapper.CompanyInputDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
@Repository
public class CompanyInputDictDaoImpl implements CompanyInputDictDao {
    @Autowired
    CompanyInputDictMapper companyInputDictMapper;

    @Override
    public List<CompanyInputDict> findAllCompanyInputDict() {
        return companyInputDictMapper.findAllCompanyInputDict();
    }
}
