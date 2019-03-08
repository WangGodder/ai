package com.swu.ai.Util;

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
