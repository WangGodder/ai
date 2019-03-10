package com.swu.ai.dao;

import com.swu.ai.entity.CompanyInput;
import com.swu.ai.request.CompanyFigureReq;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.vo.VoFingerResult;

import java.util.List;
import java.util.Map;

/**
 * @author mhp
 * @date 2019/3/3 22:12
 */
public interface CompanyInputDao {
    boolean insertCompanyInfo(List<CompanyInput> list);

    List<CompanyInput> findAllCompanyInput();

    List<CompanyInput> findCompanyInputByTime(int beginYear, int beginQuarter, int endYear, int endQuarter);

    List<CompanyInput> findCompanyInputByCompanyName(String companyname);

    List<CompanyInput> findCompanyInputByIndustry(String industry);

    List<CompanyInput> findCompanyInputByRegion(String region);

    List<CompanyInput> findCompanyInputByReq(CompanyInputReq companyInputReq);

    CompanyInput findCompanyInputById(Long id);

    boolean updateCompanyInput(CompanyInput companyInput);

    boolean updateCompanyInputByCompanyName(CompanyInput companyInput);

    boolean existCompanyName(String companyName);

    boolean deleteCompanyInput(Long id);

    List<VoFingerResult> findSumAllByYearAndQuarter(CompanyFigureReq companyFigureReq);

    List<VoFingerResult> findMaxAllByYearAndQuarter(CompanyFigureReq companyFigureReq);
}
