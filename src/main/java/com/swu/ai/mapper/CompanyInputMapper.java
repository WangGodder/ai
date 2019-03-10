package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.request.CompanyFigureReq;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.vo.VoFingerResult;

import java.util.List;
import java.util.Map;

public interface CompanyInputMapper extends BaseMapper<CompanyInput> {
    List<CompanyInput> findAllCompanyInput();

    List<CompanyInput> findCompanyInputByTime(Map<String, Integer> timeMap);

    List<CompanyInput> findCompanyInputByCompanyName(String companyname);

    List<CompanyInput> findCompanyInputByIndustry(String industry);

    List<CompanyInput> findCompanyInputByRegion(String region);

    List<CompanyInput> findCompanyInputByReq(CompanyInputReq companyInputReq);

    CompanyInput findCompanyInputById(Long id);

    boolean insertCompanyInput(CompanyInput companyInput);

    boolean updateCompanyInput(CompanyInput companyInput);

    boolean updateCompanyInputByCompanyName(CompanyInput companyInput);

    boolean deleteCompanyInput(Long id);

    List<VoFingerResult> findFingerSumByYearAndQuarter(CompanyFigureReq companyFigureReq);

    List<VoFingerResult> findFingerMaxByYearAndQuarter(CompanyFigureReq companyFigureReq);
}