package com.swu.ai.Controller;

import com.swu.ai.Result.JsonResult;
import com.swu.ai.entity.UserTk;
import com.swu.ai.request.UserReq;
import com.swu.ai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mhp
 * @date 2019/3/2 17:27
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/user/")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("login/")
    public String index(){
        return "login";
    }

    @PostMapping(value = "checkLogin/")
    @ResponseBody
    public JsonResult checkLogin(@RequestBody UserReq userReq){
        UserTk userTk = userService.getUserByUserIdAndPwd(userReq.getUserId(),userReq.getPwd());
        if (userTk != null){
            return JsonResult.success(userTk);
        }else {
            return JsonResult.fail("用户名或者密码不正确");
        }
    }
}
