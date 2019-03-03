package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.CompanyInput;

import java.util.List;

public interface CompanyInputMapper extends BaseMapper<CompanyInput> {
    List<CompanyInput> findAllCompanyInput();
    boolean insertCompanyInput(CompanyInput companyInput);
}