package com.swu.ai.Controller;


import com.swu.ai.Result.BaseData;
import com.swu.ai.Result.FingerResult;
import com.swu.ai.Result.JsonResult;
import com.swu.ai.Util.FieldInject;
import com.swu.ai.Util.TableUtil;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.service.CompanyService;
import com.swu.ai.service.FingerService;

import com.swu.ai.util.ExcelData;
import com.swu.ai.vo.VoFingerResult;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    /**
     *  请注意： year 和 quarter 为必须要传入的参数，否则报错
     *  可选参数
     *      id 表示使用 finger_weight 中的权重模板 id 系统中默认是 1
     *      companyname     公司 id
     *      industry        板块
     *      region          区域
    * */
    @RequestMapping("getFingerRes2/")
    @ResponseBody
    /*
    companyId 公司ID 默认是-1表示所有
    companyPlate 公司所属板块 默认是 all 表示所有
    year 年份 默认是 2018
    quarter 全年还是季度 ： 1 一季度 2 二季度 3三季度 4四季度 默认是 1
    denominatorType 分母类型：mean平均值，max最大值，min最小值，极差值range 这一项是必选，默认是mean
    */
//    JsonResult getFingerResult2(@RequestParam(value = "year", required = false, defaultValue = "2018") Integer year,
//                                @RequestParam(value = "quarter", required = false, defaultValue = "1") Integer quarter,
//                                @RequestParam(value = "denominatorType", required = false, defaultValue = "mean") String denominatorType,
//                                @RequestParam(value = "companyPlate", required = false, defaultValue = "all") String companyPlate,
//                                @RequestParam(value = "companyId", required = false, defaultValue = "-1") Long companyId) {
    JsonResult getFingerResult2(CompanyInput companyInput) {
        if(companyInput.getYear() == null || companyInput.getQuarter() == null ){
            return JsonResult.fail("year 和 quarter 不能为空");
        }
        List<VoFingerResult> res = fingerService.getFingerResult2(companyInput);
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
    @RequestMapping(value = "upload/")
    @ResponseBody
    public JsonResult evaluation(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] files) throws IOException {
        //获取excel指标值
        List<String[]> list = ExcelData.getExcelData(files[0]);
        CompanyInput companyInput;
        List<CompanyInput> companyList = new ArrayList<CompanyInput>();
        for(int i = 2;i < list.size();i++){
             companyInput = CompanyInput.inputByArray(list.get(i));
             companyList.add(companyInput);
        }
        //插入企业信息
        companyService.insertCompanyInfo(companyList);
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


        try {
            String filePath = "E:/人才企业指数评估模板.xlsx";// 如 E:/test.docx

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

    @RequestMapping(value = "insertCompanyInfo/")
    public JsonResult insertCompanyInfo(List<CompanyInput> list) {
        Boolean r = companyService.insertCompanyInfo(list);
        return JsonResult.success();
    }

    @RequestMapping(value = "charts/")
    public String toCharts() {
        return "charts_vue";
    }

    @RequestMapping(value = "getAllCompanyInfo/")
    @ResponseBody
    public JsonResult getAllCompanyInfo() {
//        List<CompanyInput> list = companyService.findAllCompanyInput();
        BaseData<Integer> baseData = new BaseData<>();
        List<String> labels = Arrays.asList("第一指标", "第二指标", "第三指标", "第四指标", "第五指标");
        baseData.setLabels(labels);
        List<List<Integer>> datas = new ArrayList<>(2);
        datas.add(Arrays.asList(4, 5, 6, 7, 8));
        datas.add(Arrays.asList(7, 6, 5, 4, 3));
        baseData.setDatas(datas);
        baseData.setDatasetLabels(Arrays.asList("公司A", "公司B"));
//        try {
//            baseData = BaseDataUtil.companyInputToBaseData(list);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        return JsonResult.success(baseData);
    }

    @RequestMapping(value = "query/")
    public String queryPage() {
        return "data_query";
    }

    @RequestMapping(value = "companyInfoTableColumn/")
    @ResponseBody
    public JsonResult companyInfoTableColumn() {
        List<String> title = TableUtil.getFieldNames(CompanyInput.class);
        List<String> field = TableUtil.getFieldNames(CompanyInput.class);
        List<List<String>> list = new ArrayList<>(2);
        list.add(field);
        list.add(title);
        return JsonResult.success(list);
    }

    @RequestMapping(value = "queryCompanyInfoTable/")
    @ResponseBody
    public List<CompanyInput> queryCompanyInfoTable(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        CompanyInputReq companyInputReq = null;
        try {
            companyInputReq = FieldInject.createInstanceByMap(map, CompanyInputReq.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        List<CompanyInput> result = companyService.findCompanyInputByReq(companyInputReq);
        System.out.println(result);
        return result;
    }
}
