package com.swu.ai.Controller;

import com.swu.ai.Result.JsonResult;
import com.swu.ai.Util.TableUtil;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/3/8
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/data/")
public class DataShowController {
    private final CompanyService companyService;

    @Autowired
    public DataShowController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "companyInfoTableColumn/")
    public JsonResult companyInfoTableColumn() {
        return JsonResult.success(companyService.getCompanyInfoTableColumn());
    }
}
