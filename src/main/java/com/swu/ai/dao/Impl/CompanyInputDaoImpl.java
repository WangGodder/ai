package com.swu.ai.dao.Impl;

import com.swu.ai.dao.CompanyDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.mapper.CompanyInputMapper;
import com.swu.ai.vo.VoFingerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mhp
 * @date 2019/3/3 22:14
 */
@Repository
public class CompanyInputDaoImpl implements CompanyDao {
    private final CompanyInputMapper companyInputMapper;

    @Autowired
    public CompanyDaoImpl(CompanyInputMapper companyInputMapper) {
        this.companyInputMapper = companyInputMapper;
    }

    @Override
    public boolean insertCompanyInfo(List<CompanyInput> list) {
        boolean result = true;
        for (CompanyInput companyInput : list) {
            result &= companyInputMapper.insertCompanyInput(companyInput);
        }
        return result;
    }

    @Override
    public List<VoFingerResult> findAllByYearAndQuarter(Integer year, Integer quarter) {
        CompanyInput companyInput = new CompanyInput();
        companyInput.setYear(year);
        companyInput.setQuarter(quarter);
        List<VoFingerResult> fingerResultV0List = companyInputMapper.findFingerByYearAndQuarter(companyInput);
        for(FingerResultV0 fingerResultV0:fingerResultV0List){
            fingerResultV0.evaluate();
        }
        return fingerResultV0List;
    }
}
