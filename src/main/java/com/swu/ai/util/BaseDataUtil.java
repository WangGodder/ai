package com.swu.ai.Util;

import com.swu.ai.Result.BaseData;
import com.swu.ai.entity.CompanyInput;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/6
 */
public class BaseDataUtil {

    public static BaseData<Number> companyInputToBaseData(List<CompanyInput> list) throws NoSuchFieldException, IllegalAccessException {
        BaseData<Number> baseData = new BaseData<>();
        List<String> labelList = new ArrayList<>();
        Field[] fileds = CompanyInput.class.getDeclaredFields();
        for (Field field : fileds) {
            if (field.getName().equals("id")) {
                continue;
            }
            labelList.add(field.getName());
        }
        List<List<Number>> datas = new ArrayList<>(list.size());
        List<String> datasetLabels = new ArrayList<>(list.size());
        for (CompanyInput companyInput : list) {
            List<Number> data = new ArrayList<>(labelList.size());
            for (String fieldName : labelList) {
                Field field = CompanyInput.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                data.add((Number)field.get(companyInput));
            }
            datasetLabels.add(CompanyInput.class.getDeclaredField("id").get(companyInput).toString());
        }
        baseData.setTitle("test");
        baseData.setDatas(datas);
        baseData.setDatasetLabels(datasetLabels);
        baseData.setLabels(labelList);
        return baseData;
    }
}
