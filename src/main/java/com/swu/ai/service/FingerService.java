package com.swu.ai.service;

import com.swu.ai.entity.FingerResultV0;

import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:46
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
public interface FingerService {
    /*
    company_id 公司ID -1表示所有
    companyPlate 公司所属板块 默认是所有板块 all
    year 年份 默认是 2018
    period_type 全年还是季度 ： Y整年 Q1 一季度 Q2 二季度 Q3三季度 Q4四季度 默认是 Y
    denominator_type 分母类型：mean平均值，max最大值，min最小值，极差值range 这一项是必选，默认是mean
    */
    List<FingerResultV0> getFingerResult(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate);
}
