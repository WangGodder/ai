package com.swu.ai.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.swu.ai.Base.BaseResult;
import com.swu.ai.Result.FingerResult;
import com.swu.ai.Result.JsonResult;
import com.swu.ai.Result.ResultBase;
import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.service.CompanyService;
import com.swu.ai.service.FingerService;
import com.swu.ai.service.RegService;
import com.swu.ai.util.ExcelData;
import com.swu.ai.vo.VoFingerResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

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
@RequestMapping(value = "/user/")
public class FingerResultController {
    private final FingerService fingerService;
    private final CompanyService companyService;

    @Autowired
    public FingerResultController(FingerService fingerService, CompanyService companyService) {
        this.fingerService = fingerService;
        this.companyService = companyService;
    }

    @RequestMapping("getFingerRes/")
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
        System.out.println("res" + res);
        FingerResult fingerResult = new FingerResult();
        fingerResult.setRes(res);
        fingerResult.setCode("200");
        fingerResult.setComment("ok");
        return fingerResult;
    }

    @RequestMapping("getFingerRes2/")
    @ResponseBody
    /*
    companyId 公司ID 默认是-1表示所有
    companyPlate 公司所属板块 默认是 all 表示所有
    year 年份 默认是 2018
    quarter 全年还是季度 ： 1 一季度 2 二季度 3三季度 4四季度 默认是 1
    denominatorType 分母类型：mean平均值，max最大值，min最小值，极差值range 这一项是必选，默认是mean
    */
    JsonResult getFingerResult2(@RequestParam(value = "year", required = false, defaultValue = "2018") Integer year,
                                @RequestParam(value = "quarter", required = false, defaultValue = "1") Integer quarter,
//                                 @RequestParam(value = "denominatorType", required = false, defaultValue = "mean") String denominatorType,
//                                @RequestParam(value = "companyPlate", required = false, defaultValue = "all") String companyPlate,
                                @RequestParam(value = "companyId", required = false, defaultValue = "-1") Long companyId) {
        List<VoFingerResult> res = fingerService.getFingerResult2(year, quarter, companyId);
        return JsonResult.success(res);
    }

    /**
     * 解析excel内容
     *
     * @param request
     * @param response
     * @param files
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "evaluation/")
    @ResponseBody
    public JsonResult evaluation(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] files) throws IOException {
//        if (files.length == 1) {
//            return JsonResult.fail("上传文件数量不足");
//        }
        System.out.println(files[0].getName());
        System.out.println(files[1].getName());
        List<String[]> list = ExcelData.getExcelData(files[0]);
        return JsonResult.success(list);
    }

    /**
     * 下载excel模板
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "downloadFile/")
    public Object downloadExcel(HttpServletRequest request, HttpServletResponse response) {
        String classPath = null;
        try {
            classPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        System.out.println(url);

        try {
            String filePath = "E:/19.jpg";// 如 E:/test.docx

            // You must tell the browser the file type you are going to send
            // for example application/pdf, text/plain, text/html, image/jpg
            String fileType = "text/plain";//纯文本
            response.setContentType(fileType);

            String fileName = "";
            int pos = 0;
            if ((pos = filePath.lastIndexOf("/")) > 0) {
                fileName = filePath.substring(pos + 1, filePath.length());//截取文件名字
            } else {
                fileName = filePath;
            } //没有父文件夹，如"1.txt"

            //设置响应头
            //适应中文文件名

            String agent = (String) request.getHeader("USER-AGENT");
            if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                fileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
            } else {
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            }

            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

            // Assume file name is retrieved from database
            // For example D:\\file\\test.pdf
            File my_file = new File(filePath);
            System.out.println("要下载文件:" + my_file);
            if (!my_file.exists()) {
                throw new Exception("文件不存在");
            }

            // This should send the file to browser
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(my_file);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
            System.out.println("下载成功: ");
            return null;
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            Map<String, String> map = new HashMap<String, String>();//返回成功、失败信息
            map.put("status", "false");
            map.put("reason", e.getMessage());
            return map;
        }
    }

    @RequestMapping(value = "formSubmit/")
    @ResponseBody
    public JsonResult formSubmit(HttpServletRequest request, @RequestParam("prove") MultipartFile proveFile) {
        System.out.println(proveFile.getOriginalFilename());
        Map<String, String[]> map = request.getParameterMap();
        CompanyInput companyInput = CompanyInput.inputByMap(map);
        System.out.println(companyInput);
//        System.out.println(map);
//        System.out.println(companyInput.getCompanyname());
//        System.out.println(file.getName());
        return JsonResult.success(companyInput);
    }

    @RequestMapping(value = "insertCompanyInfo/")
    public JsonResult insertCompanyInfo(List<CompanyInput> list) {
        Boolean r = companyService.insertCompanyInfo(list);
        return JsonResult.success();
    }
}
