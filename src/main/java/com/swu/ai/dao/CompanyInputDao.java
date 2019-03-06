package com.swu.ai.dao;

import com.swu.ai.entity.CompanyInput;

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

    CompanyInput findCompanyInputById(Long id);

    boolean updateCompanyInput(CompanyInput companyInput);

    boolean updateCompanyInputByCompanyName(CompanyInput companyInput);

    boolean existCompanyName(String companyName);

    boolean deleteCompanyInput(Long id);
}
