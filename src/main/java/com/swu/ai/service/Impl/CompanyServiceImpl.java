package com.swu.ai.service.Impl;

import com.swu.ai.dao.CompanyDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mhp
 * @date 2019/3/3 22:19
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao companyDao;
    @Override
    public boolean insertCompanyInfo(List<CompanyInput> list) {
        return companyDao.insertCompanyInfo(list);
    }
}
