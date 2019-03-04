package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.vo.VoFingerResult;

import java.util.List;
import java.util.Map;

public interface CompanyInputMapper extends BaseMapper<CompanyInput> {
//    List<CompanyInput> findAllCompanyInput();
//    List<CompanyInput> findCompanyInputByTime(Map<String, Integer> timeMap);
    boolean insertCompanyInput(CompanyInput companyInput);

    List<VoFingerResult> findFingerByYearAndQuarter(CompanyInput companyInput);
}