package com.swu.ai.service.Impl;

import com.alibaba.fastjson.JSON;
import com.swu.ai.Result.BaseData;
import com.swu.ai.Result.CompanyInputBase;
import com.swu.ai.Result.EvaluateDetailTable;
import com.swu.ai.Result.TreeData;
import com.swu.ai.Util.FieldInject;
import com.swu.ai.Util.TableUtil;
import com.swu.ai.dao.*;
import com.swu.ai.entity.*;
import com.swu.ai.request.ChartReq;
import com.swu.ai.request.CompanyFigureReq;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.request.EvaluateResultReq;
import com.swu.ai.service.FingerService;
import com.swu.ai.vo.VoFingerResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.util.*;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:47
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
@Service
public class FingerServiceImpl implements FingerService {
    /**
     * 指标计算方法
     */
    public static final int AVG = 0;            // 平均数
    public static final int MAX = 1;            // 最大值
    public static final int MIN = 2;            // 最小值
    public static final int FIRST_QUARTILE = 3; // 第一分位数
    public static final int MEDIAN = 4;         // 中位数
    public static final int THIRD_QUARTILE = 5; // 第三分位数
    public static int RESULT_INDATE = 5;            // 计算数据有效期，如果获取的计算结果超过有效期则重新计算 单位 小时

    @Resource
    private FingerDao fingerDao;
    @Resource
    private CompanyInputDao companyInputDao;
    @Resource
    private CompanyInputDictDao companyInputDictDao;
    @Resource
    private EvaluateResultDao evaluateResultDao;
    @Resource
    private FigureWeightDao figureWeightDao;
    @Resource
    private FigureDictDao figureDictDao;
    @Resource
    private com.swu.ai.util.RedisUtil redisUtil;

    @Override
    public List<FingerResultV0> getFingerResult(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate){
        return fingerDao.findAllResultByCondition(year, periodType, denominatorType, companyId, companyPlate);
    }

    @Override
    public List<VoFingerResult> getFingerResultSum2(CompanyFigureReq companyInput){
        return companyInputDao.findSumAllByYearAndQuarter(companyInput);
    }

    @Override
    public List<VoFingerResult> getFingerResultMax2(CompanyFigureReq companyInput){
        return companyInputDao.findMaxAllByYearAndQuarter(companyInput);
    }

    @Override
    public List<EvaluateResult> evaluateCompany(EvaluateResultReq req) {
        // 查找数据库内是否有存放的已算出结果
//        List<EvaluateResult> results = evaluateResultDao.findEvaluateResultByReq(req);
//        if (results != null && results.size() > 0) {
//            // 判断获取数据是否在有效期内
//            long timeGas = System.currentTimeMillis() - results.get(0).getEvaluateDate().getTime();
//            if (timeGas < RESULT_INDATE * 1000 * 60 * 60) {
//                return results;
//            }
//        }

        // 获取范围内所有的数据
        List<CompanyInput> companyInputs = null;
        CompanyInputBase base = null;
        // 获取查询请求在redis上保留的对应结果
        String keyRedis = calcIdByCompanyInputReq(req);
//        String keyRedisBase = "base" + keyRedis;
        // 如果redis连接失败，则直接计算
        boolean saveEvaluate = true;
        try {
            String resultStr = redisUtil.get(keyRedis);
            if (resultStr != null && !resultStr.isEmpty()) {
                List<EvaluateResult> results = JSON.parseArray(resultStr, EvaluateResult.class);
                return results;
            }
//            String redisBase = redisUtil.get(keyRedisBase);
//            // 判断redis上是否存有基数,若没有则生成并存入redis
//            if (redisBase == null || redisBase.isEmpty()) {
//                calcBaseAndStore(companyInputs, req);
//            }
//            base = JSON.parseObject(redisUtil.get(keyRedisBase), CompanyInput.class);
        } catch (Exception e) {
            System.err.println("redis 连接错误, 无法获取redis中数据");
            saveEvaluate = false;
        }
        companyInputs = companyInputDao.findCompanyInputSumByReq(req);
        switch (req.getEvaluateType()) {
            case "avg": base = calcBase(companyInputs).get(AVG); break;
            case "max":
                base = calcBase(companyInputs).get(MAX); break;
            case "min":
                base = calcBase(companyInputs).get(MIN); break;
            case "firstQ":
                base = calcBase(companyInputs).get(FIRST_QUARTILE); break;
            case "median":
                base = calcBase(companyInputs).get(MEDIAN); break;
            case "thirdQ":
                base = calcBase(companyInputs).get(THIRD_QUARTILE); break;
        }
        // 计算获取数据的三级指标的得分
        List<EvaluateResult> evaluateResultList = new ArrayList<>(companyInputs.size());
        FigureWeight figureWeight = figureWeightDao.getFigureWeight(req.getFigureId());
        for (CompanyInput companyInput : companyInputs) {
            EvaluateResult evaluateResult = evaluteFigure(companyInput, base);
            evaluateResult.evaluate(figureWeight);
            evaluateResult.setEvaluateDate(new Date());
            evaluateResult.setEvaluateType(req.getEvaluateType());
            evaluateResult.setBeginYear(req.getBeginYear());
            evaluateResult.setEndYear(req.getEndYear());
            evaluateResult.setBeginQuarter(req.getBeginQuarter());
            evaluateResult.setEndQuarter(req.getEndQuarter());
            evaluateResult.setIndustry(req.getIndustry());
            evaluateResult.setRegion(req.getRegion());
            // 存入数据库
//            evaluateResultDao.addEvaluateResult(evaluateResult);
            // 展示结果中显示实际公司的所在行业和地区
            evaluateResult.setIndustry(companyInput.getIndustry());
            evaluateResult.setRegion(companyInput.getRegion());
            evaluateResultList.add(evaluateResult);
        }
        // 按照总分降序排列
        evaluateResultList.sort((o1, o2) -> o1.getFigureAll() - o2.getFigureAll() < 0? 1 : -1);
        if (saveEvaluate) {
            String resultStr = JSON.toJSONString(evaluateResultList);
            // 将结果保存至redis，保存时间为1天
            redisUtil.set(keyRedis, resultStr, 1000 * 60 * 60 * 24);
        }
        return evaluateResultList;
    }

    @Override
    public List<Map<String, Object>> evaluateCompanyTotal(EvaluateResultReq req) {
        req.setFigureId(1L);
        HashMap<String, List<EvaluateResult>> map = new HashMap<>();
        // 计算范围内每年的得分，并按照companyName进行map,key为从开始的年依次到结束年的全部评估结果
        for (int i = req.getBeginYear(); i <= req.getEndYear(); i++) {
            EvaluateResultReq currentReq = null;
            try {
                currentReq = (EvaluateResultReq) req.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            currentReq.setEndYear(i);
            currentReq.setBeginYear(i);
            currentReq.setEvaluateType(req.getEvaluateType());
            // 获取该年的所有公司的评估结果
            List<EvaluateResult> evaluateResultList = this.evaluateCompany(currentReq);
            for (EvaluateResult evaluateResult : evaluateResultList) {
                if (map.get(evaluateResult.getCompanyName()) == null) {
                    map.put(evaluateResult.getCompanyName(), new ArrayList<>());
                    // 如果前几年没有数据，则不齐空值
                    for (int j = i - req.getBeginYear(); j > 0; j--) {
                        map.get(evaluateResult.getCompanyName()).add(new EvaluateResult());
                    }
                }
                map.get(evaluateResult.getCompanyName()).add(evaluateResult);
            }
        }
        List<Map<String, Object>> result = new ArrayList<>(map.size());
        String[] fileds = {"figureAll", "figureSale", "figureTax", "figureFinance", "figureValuation", "figureHr", "figureInnovate", "figureSalary", "figureLearn", "figureBrand"};
        for (Map.Entry<String, List<EvaluateResult>> entry : map.entrySet()) {
            Map<String, Object> line = new HashMap<>(3 + (req.getEndYear() - req.getBeginYear()) * 10);
            line.put("companyName", entry.getKey());
            line.put("industry", entry.getValue().get(0).getIndustry());
            line.put("region", entry.getValue().get(0).getRegion());
            int yearNum = 0;
            for (EvaluateResult evaluateResult : entry.getValue()) {
                try {
                    Map<String, Object> currentMap = FieldInject.getFieldMap(EvaluateResult.class, evaluateResult, fileds);
                    for (String field : fileds) {
                        line.put(field + yearNum, currentMap.get(field));
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                yearNum++;
            }
            result.add(line);
        }

        return result;
    }

    @Override
    public EvaluateDetailTable getEvaluateDetailTable() {
        List<String> titles = new ArrayList<>(100);
        List<String> head  = Arrays.asList("公司名称", "所在行业", "所在地区");
        titles.addAll(head);
        titles.add("综合指标");
        List<String> figureV3List = getFigureV3List();
        List<FigureDict> figureV1DictList = figureDictDao.findFigureDictByLevel(1);
        List<FigureDict> figureV2DictList = figureDictDao.findFigureDictByLevel(2);
        Iterator<FigureDict> iteratorV1 = figureV1DictList.iterator();
        Iterator<FigureDict> iteratorV2 = figureV2DictList.iterator();
        Iterator<String> iteratorV3 = figureV3List.iterator();
        while (iteratorV1.hasNext() && iteratorV2.hasNext()) {
            FigureDict figureV1 = iteratorV1.next();
            titles.add(figureV1.getFigureName());
            int totalFigureV3Num = 0;
            FigureDict figureV2 = iteratorV2.next();
            titles.add(figureV2.getFigureName());
            int currentFigureV3Num = 0;
            while (totalFigureV3Num < figureV1.getSubFigureNum()) {
                if (currentFigureV3Num == figureV2.getSubFigureNum()) {
                    figureV2 = iteratorV2.next();
                    titles.add(figureV2.getFigureName());
                    currentFigureV3Num = 0;
                }
                titles.add(iteratorV3.next());
                totalFigureV3Num++;
                currentFigureV3Num++;
            }
        }
        List<String> fields = TableUtil.getFieldNames(EvaluateResult.class);
        List<String> unuseFields = Arrays.asList("id", "figureId", "evaluateDate", "evaluateType", "beginYear", "endYear", "beginQuarter", "endQuarter");
        fields.removeAll(unuseFields);
        EvaluateDetailTable table = new EvaluateDetailTable();
        table.setTitles(titles);
        table.setFields(fields);
        return table;
    }

    @Override
    public List<TreeData<String>> getFigureWeightTree() {
        List<TreeData<String>> list = new ArrayList<>(9);
        List<FigureDict> figureV1DictList = figureDictDao.findFigureDictByLevel(1);
        List<FigureDict> figureV2DictList = figureDictDao.findFigureDictByLevel(2);
        List<String> figureV3List = getFigureV3List();
        List<String> fieldList = TableUtil.getFieldNames(FigureWeight.class);
        List<String> valueList = TableUtil.getFieldValues(FigureWeight.class, figureWeightDao.getFigureWeight(1l), "0");
        // remove id
        fieldList.remove(0);
        valueList.remove(0);

        // 遍历加入
        Iterator<FigureDict> iteratorV1 = figureV1DictList.iterator();
        Iterator<FigureDict> iteratorV2 = figureV2DictList.iterator();
        Iterator<String> iteratorV3 = figureV3List.iterator();
        int index = 0;
        while (iteratorV1.hasNext()) {
            FigureDict figureDict = iteratorV1.next();
            TreeData<String> root = new TreeData<>(figureDict.getFigureName(), fieldList.get(index), valueList.get(index));
            index++;
            if (figureDict.getSubFigureNum() == 0) {
                list.add(root);
                continue;
            }
            List<TreeData<String>> childrenV2 = new ArrayList<>(figureDict.getSubFigureNum()/2);
            FigureDict figureDictV2 = iteratorV2.next();
            TreeData<String> child = new TreeData<>(figureDictV2.getFigureName(), fieldList.get(index), valueList.get(index));
            index++;
            List<TreeData<String>> childrendV3 = new ArrayList<>(figureDictV2.getSubFigureNum());
            int totalNum = 0, currentNum = 0;
            while (iteratorV3.hasNext() && totalNum < figureDict.getSubFigureNum()) {
                if (currentNum == figureDictV2.getSubFigureNum()) {
                    child.setChildren(childrendV3);
                    childrenV2.add(child);
                    figureDictV2 = iteratorV2.next();
                    childrendV3 = new ArrayList<>(figureDictV2.getSubFigureNum());
                    child = new TreeData<>(figureDictV2.getFigureName(), fieldList.get(index), valueList.get(index));
                    index++;
                    currentNum = 0;
                }
                childrendV3.add(new TreeData<>(iteratorV3.next(), fieldList.get(index), valueList.get(index)));
                index++; totalNum++; currentNum++;
            }
            child.setChildren(childrendV3);
            childrenV2.add(child);
            root.setChildren(childrenV2);
            list.add(root);
        }
        return list;
    }

    @Override
    public BaseData<Number> baseDataTime(ChartReq req) {
        List<Map<String, Object>> mapList = evaluateCompanyTotal(req);
        BaseData<Number> baseData = new BaseData<>();
        List<String> labels = new ArrayList<>(req.getEndYear() - req.getBeginYear() + 1);
        for (int i = req.getBeginYear(); i <= req.getEndYear(); i++) {
            labels.add(Integer.toString(i));
        }
        List<String> datasetLabels = new ArrayList<>(mapList.size());
        List<List<Number>> datas = new ArrayList<>(mapList.size());
        for (Map<String, Object> map : mapList) {
            datasetLabels.add((String) map.get("companyName"));
            List<Number> data = new ArrayList<>(req.getEndYear() - req.getBeginYear() + 1);
            for (int i = 0; i <= req.getEndYear() - req.getBeginYear(); i++) {
                if (map.get(req.getFigureShow() + i) == null) {
                    data.add(0.0);
                } else {
                    data.add((Number) map.get(req.getFigureShow() + i));
                }
            }
            datas.add(data);
        }
        baseData.setDatasetLabels(datasetLabels);
        baseData.setLabels(labels);
        baseData.setDatas(datas);
        return baseData;
    }

    @Override
    public BaseData<Number> baseDataTotal(EvaluateResultReq req) {
        List<EvaluateResult> list = evaluateCompany(req);
        BaseData<Number> baseData = new BaseData<>();
        String[] fieldNames = {"figureAll", "figureSale", "figureTax", "figureFinance", "figureValuation", "figureHr", "figureInnovate", "figureSalary", "figureLearn", "figureBrand"};
        List<String> labels = new ArrayList<>(10);
        labels.add("综合指标");
        List<FigureDict> figureDicts = figureDictDao.findFigureDictByLevel(1);
        for (FigureDict figureDict : figureDicts) {
            labels.add(figureDict.getFigureName());
        }
        List<String> datasetLabels = new ArrayList<>(list.size());
        List<List<Number>> datas = new ArrayList<>(list.size());
        for (EvaluateResult evaluateResult : list) {
            datasetLabels.add(evaluateResult.getCompanyName());
            Map<String, Object> fieldMap = null;
            try {
                fieldMap = FieldInject.getFieldMap(EvaluateResult.class, evaluateResult);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            if (fieldMap == null) {
                continue;
            }
            List<Number> data = new ArrayList<>(fieldNames.length);
            for (String fieldName : fieldNames) {
                if (fieldMap.get(fieldName) == null) {
                    data.add(0.);
                } else {
                    data.add((Number) fieldMap.get(fieldName));
                }
            }
            datas.add(data);
        }
        baseData.setDatas(datas);
        baseData.setLabels(labels);
        baseData.setDatasetLabels(datasetLabels);
        return baseData;
    }

    @Override
    public boolean addFigureWeight(FigureWeight figureWeight) {
        return figureWeightDao.addFigureWeight(figureWeight);
    }

    /**
     * 获取三级指标的所有title(中文名称)
     * @return
     */
    private List<String> getFigureV3List() {
        List<String> companyFields = TableUtil.getFieldNames(CompanyInput.class);
        Map<String, String> map = getCompanyInfoDictMap();
        List<String> figureV3List = new ArrayList<>(companyFields.size());
        for (int i = 6; i < companyFields.size(); i++) {
            figureV3List.add(map.get(companyFields.get(i)));
        }
        return figureV3List;
    }

    /**
     * 获取公司属性的对应中文表
     * @return
     */
    private Map<String, String> getCompanyInfoDictMap() {
        List<CompanyInputDict> list = companyInputDictDao.findAllCompanyInputDict();
        Map<String, String> map = new HashMap<>(list.size());
        for (CompanyInputDict companyInputDict : list) {
            map.put(companyInputDict.getName(), companyInputDict.getValue());
        }
        return map;
    }

    /**
     * 获取计算的base并存入redis
     * @param inputs 范围内的所有数据
     * @param req 评估结果请求，用于生成key
     */
    private void calcBaseAndStore(List<CompanyInput> inputs, EvaluateResultReq req) {
        List<CompanyInputBase> baseList = calcBase(inputs);
        for (int i = 0; i < baseList.size(); i++) {
            EvaluateResultReq resultReq = req;
            switch (i) {
                case AVG:
                    resultReq.setEvaluateType("avg");
                    redisUtil.set(calcIdByCompanyInputReq(resultReq), JSON.toJSONString(baseList.get(i)), 60 * 60 * RESULT_INDATE);
                    break;
                case MAX:
                    resultReq.setEvaluateType("max");
                    redisUtil.set(calcIdByCompanyInputReq(resultReq), JSON.toJSONString(baseList.get(i)), 60 * 60 * RESULT_INDATE);
                    break;
                case MIN:
                    resultReq.setEvaluateType("min");
                    redisUtil.set(calcIdByCompanyInputReq(resultReq), JSON.toJSONString(baseList.get(i)),  60 * 60 * RESULT_INDATE);
                    break;
                case FIRST_QUARTILE:
                    resultReq.setEvaluateType("firstQ");
                    redisUtil.set(calcIdByCompanyInputReq(resultReq), JSON.toJSONString(baseList.get(i)),  60 * 60 * RESULT_INDATE);
                    break;
                case MEDIAN:
                    resultReq.setEvaluateType("median");
                    redisUtil.set(calcIdByCompanyInputReq(resultReq), JSON.toJSONString(baseList.get(i)),  60 * 60 * RESULT_INDATE);
                    break;
                case THIRD_QUARTILE:
                    resultReq.setEvaluateType("thirdQ");
                    redisUtil.set(calcIdByCompanyInputReq(resultReq), JSON.toJSONString(baseList.get(i)),  60 * 60 * RESULT_INDATE);
                    break;
            }
        }
    }

    /**
     * 根据EvaluateResultReq和计算方式生成针对于当前时间的无重复ID, 作为redis的key值
     * @param req
     * @return
     */
    private String calcIdByCompanyInputReq(EvaluateResultReq req) {
        StringBuilder sb = new StringBuilder();
        sb.append(req.getEvaluateType());
        sb.append(req.getIndustry());
        sb.append(req.getBeginYear());
        sb.append(req.getEndYear());
        sb.append(req.getBeginQuarter());
        sb.append(req.getEndQuarter());
        return Integer.toString(sb.toString().hashCode());
    }

    /**
     * 根据请求获取CompanyInput,并分别求出均值、最大值、最小值、四分位数等结果
     * @param companyInputs 评估范围内所有值
     * @return 按照均值、最大值、最小值、1分位、中位、3分位返回
     */
    private List<CompanyInputBase> calcBase(List<CompanyInput> companyInputs) {
        List<CompanyInputBase> list = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            list.add(new CompanyInputBase());
        }
        Field[] fields = CompanyInput.class.getDeclaredFields();
        int index = 0;
        for (CompanyInput companyInput : companyInputs) {
            for (int i = 6; i <fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                try {
                    Object r= field.get(companyInput);
                    Double read = null;
                    if (field.getGenericType() == Integer.class) {
                        read = Double.parseDouble(Integer.toString((int)r));
                    } else {
                        read = (double) r;
                    }
                    Field baseField = CompanyInputBase.class.getDeclaredField(field.getName());
                    baseField.setAccessible(true);
                    // first-quartile
                    if (index == companyInputs.size() / 4 - 1) {
                        baseField.set(list.get(3), read);
                    }
                    // median
                    if (index == companyInputs.size() / 2 - 1) {
                        baseField.set(list.get(4), read);
                    }
                    // third-quartile
                    if (index == companyInputs.size() / 4 * 3 - 1) {
                        baseField.set(list.get(5), read);
                    }
                    // sum
                    baseField.set(list.get(0), (double)baseField.get(list.get(0)) + (double)read);
                    // max
                    if ((double)baseField.get(list.get(1)) < (double)read) {
                        baseField.set(list.get(1), read);
                    }
                    // min
                    if ((double)baseField.get(list.get(2)) > (double)read) {
                        baseField.set(list.get(2), read);
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            index++;
        }
        // avg
        for (int i = 6; i < fields.length; i++) {
            Field field = fields[i];
            try {
                Field baseField = CompanyInputBase.class.getDeclaredField(field.getName());
                baseField.setAccessible(true);
                baseField.set(list.get(0), (double)baseField.get(list.get(0)) / companyInputs.size());

                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 根据基数进行评估，返回输入公司数据的最低级指标的评估结果
     * @param companyInput 被评估公司的录入数据
     * @param base 得分相除数据的基数(需要通过其他函数获取，并计算)
     * @return 包含最低级指标的评估结果 （不含高级指标，请调用EvaluateResult.evaluate方法获取完整评估结果）
     */
    private EvaluateResult evaluteFigure(CompanyInput companyInput, CompanyInputBase base) {
        EvaluateResult result = new EvaluateResult();
        result.setCompanyName(companyInput.getCompanyname());
        // 二级指标：已开票的收入
        result.setFigureSaleInvoiceSoft(companyInput.getTicketincomesoftware() / base.getTicketincomesoftware());
        result.setFigureSaleInvoiceHard(companyInput.getTicketincomehardware() / base.getTicketincomehardware());
        result.setFigureSaleInvoiceConsultation(companyInput.getTicketincomeconsult() / base.getTicketincomeconsult());
        result.setFigureSaleInvoiceOther(companyInput.getTicketincomeother() / base.getTicketincomeother());
        // 二级指标：合同收入
        result.setFigureSaleContractSoft(companyInput.getContractincomesoftware() / base.getContractincomesoftware());
        result.setFigureSaleContractHard(companyInput.getContractincomehardware() / base.getContractincomehardware());
        result.setFigureSaleContractConsultation(companyInput.getContractincomeconsult() / base.getContractincomeconsult());
        result.setFigureSaleContractOther(companyInput.getContractincomeother() / base.getContractincomeother());
        // 二级指标：企业所得税
        result.setFigureTaxCorporateRelief(companyInput.getIncometaxdeduction() / base.getIncometaxdeduction());
        result.setFigureTaxCorporateTaxable(companyInput.getIncometaxable() / base.getIncometaxable());
        // 二级指标：个人所得税
        result.setFigureTaxIndividualRelief(companyInput.getPensonaltaxdecution() / base.getPensonaltaxdecution());
        result.setFigureTaxIndividualTaxable(companyInput.getPensonaltaxable() / base.getPensonaltaxable());
        // 二级指标：附加税
        result.setFigureTaxAddedRelief(companyInput.getAddvaluetaxdecution() / base.getAddvaluetaxdecution());
        result.setFigureTaxAddedTaxable(companyInput.getAddvaluetaxable() / base.getAddvaluetaxable());
        // 二级指标：股权类融资
        result.setFigureFinanceStockRisk(companyInput.getStockfinancevc() / base.getStockfinancevc());
        result.setFigureFinanceStockGov(companyInput.getStockfinancegovenment() / base.getStockfinancegovenment());
        result.setFigureFinanceStockPerson(companyInput.getStockfinancepensonal() / base.getStockfinancepensonal());
        // 二级指标：债务类融资
        result.setFigureFinanceDebtBank(companyInput.getDebtfinancebank() / base.getDebtfinancebank());
        result.setFigureFinanceDebtNew(companyInput.getDebtfinanceli() / base.getDebtfinanceli());
        result.setFigureFinanceDebtLending(companyInput.getDebtfinancecompany() / base.getDebtfinancecompany());
        result.setFigureFinanceDebtPerson(companyInput.getDebtfinancepensonal() / base.getDebtfinancepensonal());
        // 二级指标：净资产
        result.setFigureValuationAssetsCirculating(companyInput.getCurrentasset() / base.getCurrentasset());
        result.setFigureValuationAssetsUncirculating(companyInput.getNocurrentasset() / base.getNocurrentasset());
        result.setFigureValuationAssetsDebtCirculating(companyInput.getCurrentdebt() / base.getCurrentdebt());
        result.setFigureValuationAssetsDebtUncirculating(companyInput.getNocurrentdebt() / base.getNocurrentdebt());
        // 二级指标：实际 估计值
        result.setFigureValuationActualFirst(companyInput.getFirstfinancevalue() / base.getFirstfinancevalue());
        result.setFigureValuationActualLatest(companyInput.getLastfinancevalue() / base.getLastfinancevalue());
        result.setFigureValuationActualWant(companyInput.getCurrentfinancevalue() / base.getCurrentfinancevalue());
        // 二级指标：兼职员工数
        result.setFigureHrPartimeDev((double)companyInput.getParttimedevelopment() / (double)base.getParttimedevelopment());
        result.setFigureHrPartimeManage((double) companyInput.getParttimemanager() / (double) base.getParttimemanager());
        result.setFigureHrPartimeAdmin((double) companyInput.getParttimeadmin() / (double) base.getParttimeadmin());
        result.setFigureHrPartimeSaler((double) companyInput.getParttimesell() / (double) base.getParttimesell());
        // 二级指标：全职员工
        result.setFigureHrFulltimeDev((double) companyInput.getDevelopment() / (double) base.getDevelopment());
        result.setFigureHrFulltimeSenior((double) companyInput.getManamger() / (double) base.getManamger());
        result.setFigureHrFulltimeAdmin((double) companyInput.getAdministrator() / (double) base.getAdministrator());
        result.setFigureHrFulltimeSaler((double) companyInput.getSell() / (double) base.getSell());
        // 二级指标：高学历员工
        result.setFigureHrEducatedDoc((double) companyInput.getDoctor() / (double) base.getDoctor());
        result.setFigureHrEducatedMaster((double) companyInput.getMaster() / (double) base.getMaster());
        result.setFigureHrBachelor((double) companyInput.getBachelor() / (double) base.getBachelor());
        // 二级指标：申请专利
        result.setFigureInnovatePatentApplyInvention((double) companyInput.getApplypatentinvent() / (double) base.getApplypatentinvent());
        result.setFigureInnovatePatentApplyUtility((double) companyInput.getApplypatentindustry() / (double) base.getApplypatentindustry());
        result.setFigureInnovatePatentApplyAppear((double) companyInput.getApplypatentdesign() / (double) base.getApplypatentdesign());
        // 二级指标：授权专利
        result.setFigureInnovatePatentGrantInvention((double) companyInput.getPatentinvent() / (double) base.getPatentinvent());
        result.setFigureInnovatePatentGrantUtility((double) companyInput.getPatentindustry() / (double) base.getPatentindustry());
        result.setFigureInnovatePatentGrantAppear((double) companyInput.getPatentdesign() / (double) base.getPatentdesign());
        // 二级指标：申请著作权
        result.setFigureInnovateCopyrightApplySoft((double) companyInput.getApplyauthorsoftware() / (double) base.getApplyauthorother());
        result.setFigureInnovateCopyrightApplyUnsoft((double) companyInput.getApplyauthorother() / (double) base.getApplyauthorother());
        // 二级指标：授权著作权
        result.setFigureInnovateCopyrightGrantSoft((double) companyInput.getAuthorsoftware() / (double) base.getAuthorsoftware());
        result.setFigureInnovateCopyrightGrantUnsoft((double) companyInput.getAuthorother() / (double) base.getAuthorother());
        // 二级指标：新服务
        result.setFigureInnovateNewProductPatent((double) companyInput.getServicepatent() / (double) base.getServicepatent());
        result.setFigureInnovateNewProductTech((double) companyInput.getServiceskill() / (double) base.getServiceskill());
        result.setFigureInnovateNewProductBus((double) companyInput.getServicesell() / (double) base.getServicesell());
        // 二级指标：员工工资额
        result.setFigureSalaryStaffUp10(companyInput.getSalaryhigh() / base.getSalaryhigh());
        result.setFigureSalaryStaff510(companyInput.getSalarymiddle() / base.getSalarymiddle());
        result.setFigureSalaryStaffDown5(companyInput.getSalarylow() / base.getSalarylow());
        // 二级指标：员工贡献率
        result.setFigureSalaryStaffContributionMeansale(companyInput.getPersell() / base.getPersell());
        result.setFigureSalaryStaffContributionMeantax(companyInput.getPertax() / base.getPertax());
        // 二级指标：参加培训的次数
        result.setFigureLearnTrainManage((double)companyInput.getTrainmanage() / (double)base.getTrainmanage());
        result.setFigureLearnTrainPolicy((double) companyInput.getTrainlegal() / (double) base.getTrainlegal());
        result.setFigureLearnTrainSkill((double) companyInput.getTrainskill() / (double) base.getTrainskill());
        // 二级指标：参加咨询的次数
        result.setFigureLearnConsltedManage((double) companyInput.getConsultmanage() / (double) base.getConsultmanage());
        result.setFigureLearnConsltedPolicy((double) companyInput.getConsultlegal() / (double) base.getConsultlegal());
        result.setFigureLearnConsltedSkill((double) companyInput.getConsultskill() / (double) base.getConsultskill());
        // 二级指标：企业获奖
        result.setFigureBrandRewardArea((double) companyInput.getAwarddistrict() / (double) base.getAwarddistrict());
        result.setFigureBrandRewardCity((double) companyInput.getAwardcity() / (double) base.getAwardcity());
        result.setFigureBrandRewardProvince((double) companyInput.getAwardprovince() / (double) base.getAwardprovince());
        result.setFigureBrandRewardCountry((double) companyInput.getAwardnation() / (double) base.getAwardnation());
        // 二级指标：企业认定
        result.setFigureBrandRecognitionArea((double) companyInput.getComfirmdistrict() / (double) base.getComfirmdistrict());
        result.setFigureBrandRecognitionCity((double) companyInput.getComfirmcity() / (double) base.getComfirmcity());
        result.setFigureBrandRecognitionProvince((double) companyInput.getComfirmprovince() / (double) base.getComfirmprovince());
        result.setFigureBrandRecognitionCountry((double) companyInput.getComfirmnation() / (double) base.getComfirmnation());
        // 二级指标：人才资助
        result.setFigureBrandTalentArea((double) companyInput.getSupportdistrict() / (double) base.getSupportdistrict());
        result.setFigureBrandTalentCity((double) companyInput.getSupportcity() / (double) base.getSupportcity());
        result.setFigureBrandTalentProvince((double) companyInput.getSupportprovince() / (double) base.getSupportprovince());
        result.setFigureBrandTalentCountry((double) companyInput.getSupportnation() / (double) base.getSupportnation());

        Field[] fields = EvaluateResult.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType() == Double.class) {
                field.setAccessible(true);
                try {
                    if (field.get(result) != null && Double.isNaN((double)field.get(result))) {
                        field.set(result, 0.0);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
