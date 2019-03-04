package com.swu.ai.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.Ss;
import com.swu.ai.entity.UserTk;
import com.swu.ai.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class HelloWorld {
    /**
     * 通过构造器注入
     * private DependencyA a;
     * /* @Autowired
     * public DI(DependencyA a){
     * this.a = a;
     * }
     * <p>
     * 通过setter方法注入
     * private DependencyB b;
     * /* @Autowired
     * public void setDependencyB(DependencyB b){
     * this.b = b;
     * }
     * <p>
     * 通过field反射注入
     * /* @Autowired
     * private DependencyC c;
     * <p>
     * Spring4.0官方文档建议使用构造器注入。
     * 如果注入的属性是必选的属性，则通过构造器注入。
     * 如果注入的属性是可选的属性，则通过setter方法注入。
     * 至于field注入，不建议使用。
     */
    private final RegService regService;
    private final UserTkDao userTkDao;

    @Autowired
    public HelloWorld(RegService regService, UserTkDao userTkDao) {
        this.regService = regService;
        this.userTkDao = userTkDao;
    }


    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("name", "pengjb");
        return "hello";
    }

    @RequestMapping("/json")
    @ResponseBody
    UserTk getjson() {
        UserTk userTk = new UserTk();
        userTk.setPwd("dsfdsf");
        userTk.setUserid("dsfdsf");
        return userTk;
    }

    @RequestMapping("/reg")
    @ResponseBody
    Boolean reg(@RequestParam("loginPwd") String loginNum, @RequestParam("userId") String userId) {
        String pwd = creatMD5(loginNum);
        System.out.println(userId + ":" + loginNum);
        System.out.println(pwd);
        return regService.regUser(userId, pwd);
    }

    private String creatMD5(String loginNum) { // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(loginNum.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }

    @RequestMapping("/tk")
    @ResponseBody
    public Object tk() {
        //分页，根据默认配置
        int page = 1;
        int pageSize = 5;
        PageHelper.startPage(page, pageSize);
        // tk.mybatis有一个内置的example类
        Example example = new Example(UserTk.class);
        example.setOrderByClause("id desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andBetween("id", 0, 100);
        example.and(criteria);
        return userTkDao.selectByExample(example);
    }

    @RequestMapping("/tk2")
    @ResponseBody
    public Object tk2() {
        //分页，根据默认配置
        int page = 2;
        int pageSize = 5;
        PageHelper.startPage(page, pageSize);
        List<UserTk> allUser = userTkDao.findAll();
        System.out.println(allUser);
        for (UserTk userTk : allUser) {
            System.out.println(userTk);
        }
        return new PageInfo<>(allUser);
    }

    @RequestMapping("/moren")
    @ResponseBody
    Ss moren(@RequestParam(value = "a", required = false,defaultValue = "-1")long a, long b, long c) {
        Ss ss = new Ss();
        ss.setA(a);
        ss.setB(b);
        ss.setC(c);
        return ss;
    }
}
