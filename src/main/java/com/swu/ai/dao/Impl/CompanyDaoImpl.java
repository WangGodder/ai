package com.swu.ai.dao.Impl;

import com.swu.ai.dao.CompanyDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.mapper.CompanyInputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mhp
 * @date 2019/3/3 22:14
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {
    @Autowired
    CompanyInputMapper companyInputMapper;

    @Override
    public boolean insertCompanyInfo(List<CompanyInput> list) {
        return false;
    }
}
