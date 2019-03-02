package com.swu.ai.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 解析excel上传数据
 * @author mhp
 * @date 2019/2/26 11:48
 */
public class ExcelData {
    public static Log log = LogFactory.getLog(ExcelData.class);

    public static List<String[]> getExcelData(MultipartFile file) throws IOException {
        Workbook workbook = getWorkBook(file);
        List<String[]> list = new ArrayList<String[]>();
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getLastCellNum();
                    String[] cells = new String[row.getLastCellNum()];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
        }
        return list;
    }

    /**
     * 获取工作簿
     * @param file
     * @return Workbook
     */
    public static  Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007 及2007以上
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return workbook;
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return String
     */
    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = stringDateProcess(cell);
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    /**
     * 设置单元格内容
     * @param cell
     * @param value
     * @param wb
     * @param cellStyle
     */
    public static void setCellValue(Cell cell, Object value, Workbook wb, CellStyle cellStyle) {
        CreationHelper createHelper = wb.getCreationHelper();
        Font cellFont = wb.createFont();
        if (value instanceof String) {
            if (((String) value).startsWith("HYPERLINK") || ((String) value).startsWith("=HYPERLINK")) {
                cellFont.setUnderline((byte) 1);
                cellFont.setColor((byte) 12);
                cellStyle.setFont(cellFont);
                cell.setCellFormula((String) value);
            }

            cell.setCellValue((String) value);
        } else if (value instanceof Date) {
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("YYYY/MM/DD hh:mm:ss"));
            cell.setCellValue((Date) value);
        } else if (value instanceof Double) {
            cell.setCellValue(((Double) value).doubleValue());
        } else if (value instanceof Integer) {
            String str = String.valueOf(value);
            cell.setCellValue(Double.parseDouble(str));
        } else if (value instanceof Boolean) {
            cell.setCellValue(((Boolean) value).booleanValue());
        } else if (value instanceof BigDecimal) {
            cell.setCellValue(value.toString());
        }
        cell.setCellStyle(cellStyle);

    }

    /**
     * 时间格式处理
     * @param cell
     * @return
     */
    public static String stringDateProcess(Cell cell){
        String result = new String();
        if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
            SimpleDateFormat sdf = null;
            if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                sdf = new SimpleDateFormat("HH:mm");
            } else {// 日期
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            Date date = cell.getDateCellValue();
            result = sdf.format(date);
        } else if (cell.getCellStyle().getDataFormat() == 58) {
            // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            double value = cell.getNumericCellValue();
            Date date = org.apache.poi.ss.usermodel.DateUtil
                    .getJavaDate(value);
            result = sdf.format(date);
        } else {
            double value = cell.getNumericCellValue();
            CellStyle style = cell.getCellStyle();
            DecimalFormat format = new DecimalFormat();
            String temp = style.getDataFormatString();
            // 单元格设置成常规
            if (temp.equals("General")) {
                format.applyPattern("#");
            }
            result = format.format(value);
        }

        return result;
    }


//    public static List<HashMap<String, Object>> getDataFromExcelBySheetName(MultipartFile file, String sheetName, int startRowno) throws IOException {
//        ArrayList list = new ArrayList();
//
//        Workbook workbook = getWorkBook(file);
//
//        if (ObjectUtil.isEmpty(workbook))
//            throw new IOException("读取excel异常");
//
//        Sheet sheet = workbook.getSheet(sheetName);
//        Row firstRow = sheet.getRow(startRowno);
//        String[] cellName = new String[firstRow.getLastCellNum()];
//        int cellNum = firstRow.getLastCellNum();
//        for (int i = 0; i < cellNum; ++i) {
//            Cell cell = firstRow.getCell(i);
//
//            String cellValue = getCellValue(cell);
//            if (ObjectUtil.isEmpty(cellValue)) {
//                break;
//            }
//
//            cellName[i] = cellValue.replaceAll("\t|\r|\n", "");
//        }
//
//        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
//
//        for (int rowno = startRowno + 1; rowno <= sheet.getLastRowNum(); ++rowno) {
//            Row var17 = sheet.getRow(rowno);
//            if (ObjectUtil.nonEmpty(var17)) {
//                boolean var18 = true;
//                HashMap rowMap = new HashMap();
//
//
//                for (int cellno = 0; cellno < cellNum; ++cellno) {
//                    Cell cell = var17.getCell(cellno);
//                    Object value = getCellValueFormula(cell, formulaEvaluator);
//                    if (value != null && !value.equals("")) {
//                        var18 = false;
//                    }
//
//                    rowMap.put(cellName[cellno], value);
//                }
//
//                if (!var18) {
//                    list.add(rowMap);
//                }
//            }
//        }
//
//        return list;
//    }

//    public static Object getCellValueFormula(Cell cell, FormulaEvaluator formulaEvaluator) {
//        if (cell != null && formulaEvaluator != null) {
//            if (cell.getCellType() == 2) {
//                CellValue value = formulaEvaluator.evaluate(cell);
//                switch (value.getCellType()) {
//                    case 0:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                            return cell.getDateCellValue();
//                        }
//
//                        cell.setCellType(1);
//                        return new BigDecimal(cell.getStringCellValue());
//                    case 1:
//                        return cell.getRichStringCellValue().getString().trim();
//                    case 2:
//                    default:
//                        break;
//                    case 3:
//                        return "";
//                    case 4:
//                        return Boolean.valueOf(cell.getBooleanCellValue());
//                    case 5:
//                        return Byte.valueOf(cell.getErrorCellValue());
//                }
//            }
//
//            return getCellValue(cell);
//        } else {
//            return null;
//        }
//    }

//    public static List<Map<String, Object>> getDataFromExcelBySheetNo(MultipartFile file, int sheetNo, int startRowno) throws IOException {
//        ArrayList list = new ArrayList();
//        Workbook workbook = getWorkBook(file);
//
//        if (ObjectUtil.isEmpty(workbook))
//            throw new IOException("读取excel异常");
//
//        Sheet sheet = workbook.getSheetAt(sheetNo);
//        Row firstRow = sheet.getRow(startRowno);
//        String[] cellName = new String[firstRow.getLastCellNum()];
//
//        for (int i = 0; i < firstRow.getLastCellNum(); ++i) {
//            Cell cell = firstRow.getCell(i);
//            String cellValue = getCellValue(cell);
//            if (ObjectUtil.isEmpty(cellValue)) {
//                break;
//            }
//
//            cellName[i] = cellValue.replaceAll("\t|\r|\n", "");
//        }
//
//        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
//        for (int rowno = startRowno + 1; rowno <= sheet.getLastRowNum(); ++rowno) {
//            Row var17 = sheet.getRow(rowno);
//            if (var17 != null) {
//                boolean var18 = true;
//                HashMap rowMap = new HashMap();
//
//                for (int cellno = 0; cellno < firstRow.getLastCellNum(); ++cellno) {
//                    Cell cell = var17.getCell(cellno);
//                    Object value = getCellValueFormula(cell, formulaEvaluator);
//                    if (value != null && !value.equals("")) {
//                        var18 = false;
//                    }
//
//                    rowMap.put(cellName[cellno], value);
//                }
//
//                if (!var18) {
//                    list.add(rowMap);
//                }
//            }
//        }
//
//        return list;
//    }
}
