package com.swu.ai.Controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.swu.ai.Base.BaseResult;
import com.swu.ai.Result.FingerResult;
import com.swu.ai.Result.JsonResult;
import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.service.FingerService;
import com.swu.ai.service.RegService;
import com.swu.ai.util.ExcelData;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
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
@RequestMapping(value = "/user/")
public class FingerResultController {
    private final FingerService fingerService;

    @Autowired
    public FingerResultController(FingerService fingerService) {
        this.fingerService = fingerService;
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
        System.out.println("res"+ res);
        FingerResult fingerResult = new FingerResult();
        fingerResult.setRes(res);
        fingerResult.setCode("200");
        fingerResult.setComment("ok");
        return fingerResult;
    }

    /**
     * 解析excel内容
     * @param request
     * @param response
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "evaluation/")
    @ResponseBody
    public JsonResult evaluation(HttpServletRequest request, HttpServletResponse response, @RequestParam("loadFile") MultipartFile file) throws IOException {

        List<String[]> list = ExcelData.getExcelData(file);
        HttpSession session = request.getSession();
//        session.setAttribute("user","mhp");
        return JsonResult.success(list);
    }

    /**
     * 下载excel模板
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "downloadFile/")
    public String downloadExcel(HttpServletRequest request,HttpServletResponse response) {



        //1.创建Excel工作薄对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //2.创建Excel工作表对象
        HSSFSheet sheet = wb.createSheet("new Sheet");
        //3.创建Excel工作表的行
        HSSFRow row = sheet.createRow(6);
        //4.创建单元格样式
        CellStyle cellStyle =wb.createCellStyle();
        // 设置这些样式
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);



        //5.创建Excel工作表指定行的单元格
        row.createCell(0).setCellStyle(cellStyle);
        //6.设置Excel工作表的值
        row.createCell(0).setCellValue("aaaa");

        row.createCell(1).setCellStyle(cellStyle);
        row.createCell(1).setCellValue("bbbb");


        //设置sheet名称和单元格内容
        wb.setSheetName(0,"第一张工作表");

        //启动资源管理器
        String filename = "MHP.xls";//设置下载时客户端Excel的名称
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);

        // 最后一步，将文件存到指定位置
        try
        {
//            FileOutputStream fout = new FileOutputStream("E:/students.xls");
            OutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



}
