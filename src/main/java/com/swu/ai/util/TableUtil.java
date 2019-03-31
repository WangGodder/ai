package com.swu.ai.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
public class TableUtil {
    public static <T> List<String> getFieldNames(Class<T> tClass) {
        Field[] fields = tClass.getDeclaredFields();
        List<String> names = new ArrayList<>(fields.length);
        for (Field field : fields) {
            names.add(field.getName());
        }
        return names;
    }

    /**
     * 获取指定对象的每个属性值的字符串
     * @param tClass 对象类型
     * @param obj 获取对象
     * @param nullValue 如果对象的该属性为null，则输入的字符串
     * @param <T> 对象类型
     * @return 对象属性值的字符串数组
     */
    public static <T> List<String> getFieldValues(Class<T> tClass, T obj, String nullValue) {
        Field[] fields = tClass.getDeclaredFields();
        List<String> values = new ArrayList<>(fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null) {
                    values.add(nullValue);
                } else {
                    values.add(field.get(obj).toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return values;
    }
}
