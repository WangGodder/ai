package com.swu.ai.Controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.swu.ai.Base.BaseResult;
import com.swu.ai.Result.FingerResult;
import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.service.FingerService;
import com.swu.ai.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:40
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */

@Controller
@EnableAutoConfiguration
public class FingerResultController {
    private final FingerService fingerService;

    @Autowired
    public FingerResultController(FingerService fingerService) {
        this.fingerService = fingerService;
    }

    @RequestMapping("/getFingerRes")
    @ResponseBody
    /*
    companyId 公司ID 默认是-1表示所有
    companyPlate 公司所属板块 默认是 all 表示所有
    year 年份 默认是 2018
    periodType 全年还是季度 ： Y整年 Q1 一季度 Q2 二季度 Q3三季度 Q4四季度 默认是 Y
    denominatorType 分母类型：mean平均值，max最大值，min最小值，极差值range 这一项是必选，默认是mean
    */
    FingerResult getFingerResult(@RequestParam(value = "year", required = false, defaultValue = "2018") Integer year,
                                 @RequestParam(value = "periodType", required = false, defaultValue = "Y") String periodType,
                                 @RequestParam(value = "denominatorType", required = false, defaultValue = "mean") String denominatorType,
                                 @RequestParam(value = "companyId", required = false, defaultValue = "-1") Long companyId,
                                 @RequestParam(value = "companyPlate", required = false, defaultValue = "all") String companyPlate) {
        List<FingerResultV0> res = fingerService.getFingerResult(year, periodType, denominatorType, companyId, companyPlate);
        System.out.println("res"+ res);
        FingerResult fingerResult = new FingerResult();
        fingerResult.setRes(res);
        fingerResult.setCode("200");
        fingerResult.setComment("ok");
        return fingerResult;
    }


}
