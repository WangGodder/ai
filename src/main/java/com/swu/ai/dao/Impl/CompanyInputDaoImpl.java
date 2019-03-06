package com.swu.ai.dao.Impl;

import com.swu.ai.dao.CompanyInputDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.mapper.CompanyInputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mhp
 * @date 2019/3/3 22:14
 */
@Repository
public class CompanyInputDaoImpl implements CompanyInputDao {
    @Autowired
    CompanyInputMapper companyInputMapper;

    @Override
    public boolean insertCompanyInfo(List<CompanyInput> list) {
        boolean result = true;
        for (CompanyInput companyInput : list) {
            result &= companyInputMapper.insertCompanyInput(companyInput);
        }
        return result;
    }

    @Override
    public List<CompanyInput> findAllCompanyInput() {
        List<CompanyInput> result = companyInputMapper.findAllCompanyInput();
        return result;
    }

    @Override
    public List<CompanyInput> findCompanyInputByTime(int beginYear, int beginQuarter, int endYear, int endQuarter) {
        Map<String, Integer> map = new HashMap<>(4);
        map.put("begin_year", beginYear);
        map.put("begin_quarter", beginQuarter);
        map.put("end_year", endYear);
        map.put("end_quarter", endQuarter);
        List<CompanyInput> result = companyInputMapper.findCompanyInputByTime(map);
        return result;
    }

    @Override
    public List<CompanyInput> findCompanyInputByCompanyName(String companyname) {
        List<CompanyInput> result = companyInputMapper.findCompanyInputByCompanyName(companyname);
        return result;
    }

    @Override
    public List<CompanyInput> findCompanyInputByIndustry(String industry) {
        List<CompanyInput> result = companyInputMapper.findCompanyInputByIndustry(industry);
        return result;
    }

    @Override
    public List<CompanyInput> findCompanyInputByRegion(String region) {
        List<CompanyInput> result = companyInputMapper.findCompanyInputByRegion(region);
        return result;
    }

    @Override
    public CompanyInput findCompanyInputById(Long id) {
        CompanyInput result = companyInputMapper.findCompanyInputById(id);
        return result;
    }

    @Override
    public boolean updateCompanyInput(CompanyInput companyInput) {
        return companyInputMapper.updateCompanyInput(companyInput);
    }

    @Override
    public boolean updateCompanyInputByCompanyName(CompanyInput companyInput) {
        return companyInputMapper.updateCompanyInputByCompanyName(companyInput);
    }

    @Override
    public boolean existCompanyName(String companyName) {
        return companyInputMapper.findCompanyInputByCompanyName(companyName).size() > 0;
    }

    @Override
    public boolean deleteCompanyInput(Long id) {
        return companyInputMapper.deleteCompanyInput(id);
    }

}
