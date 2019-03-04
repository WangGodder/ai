package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.CompanyInput;

import java.util.List;
import java.util.Map;

public interface CompanyInputMapper extends BaseMapper<CompanyInput> {
    List<CompanyInput> findAllCompanyInput();
    List<CompanyInput> findCompanyInputByTime(Map<String, Integer> timeMap);
    List<CompanyInput> findCompanyInputByCompanyName(String companyname);
    CompanyInput findCompanyInputById(Long id);
    boolean insertCompanyInput(CompanyInput companyInput);
}