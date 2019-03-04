package com.swu.ai.dao;

import com.swu.ai.entity.CompanyInput;
import com.swu.ai.vo.VoFingerResult;

import java.util.List;

/**
 * @author mhp
 * @date 2019/3/3 22:12
 */
public interface CompanyInputDao {
    boolean insertCompanyInfo(List<CompanyInput> list);

    List<VoFingerResult> findAllByYearAndQuarter(Integer year, Integer quarter);

}
