package com.swu.ai.dao;

import com.swu.ai.entity.CompanyInput;

import java.util.List;

/**
 * @author mhp
 * @date 2019/3/3 22:12
 */
public interface CompanyDao {
    boolean insertCompanyInfo(List<CompanyInput> list);
}
