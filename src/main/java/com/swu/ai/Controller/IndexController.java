package com.swu.ai.Controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mhp
 * @date 2019/3/3 21:48
 */

@Controller
@EnableAutoConfiguration
public class IndexController {
    @RequestMapping(value = "/iii")
    public String index(){
        return "login";
    }

}
