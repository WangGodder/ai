package com.swu.ai.dao;

import com.swu.ai.entity.FingerResultV0;

import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:48
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
public interface FingerDao {
    List<FingerResultV0>  findAllResultByCondition(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate);
}
