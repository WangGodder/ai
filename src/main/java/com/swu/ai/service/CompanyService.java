package com.swu.ai.service;

import com.swu.ai.entity.CompanyInput;

import java.util.List;

/**
 * @author mhp
 * @date 2019/3/3 22:18
 */
public interface CompanyService {
    boolean insertCompanyInfo(List<CompanyInput> list);
}
