package com.swu.ai.util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/3/8
 */
public class FieldInject {
    /**
     * 通过输入Map创建指定类型实例
     * @param map HttpRequest中获取的到的parameter map
     * @param tClass 获取实例对象的类型
     * @param <T> 返回的实例类型
     * @return 返回指定实例注入值后的实例
     * @throws IllegalAccessException 该类型必须有公共构造方法
     * @throws InstantiationException 该类型必须有空参构造方法
     * TODO: 该方法之支持将String转换成 Integer, Double, Float, Long, String类型
     */
    public static <T> T createInstanceByMap(Map<String, String[]> map, Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T obj = tClass.newInstance();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if (entry.getValue().length == 0 || entry.getValue().length > 1 || entry.getValue()[0].isEmpty()) {
                continue;
            }
            try {
                Field field = tClass.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                Type fieldType = field.getGenericType();
                if (fieldType == Integer.class) {
                    field.set(obj, Integer.parseInt(entry.getValue()[0]));
                    continue;
                }
                if (fieldType == Double.class) {
                    field.set(obj, Double.parseDouble(entry.getValue()[0]));
                    continue;
                }
                if (fieldType == Long.class) {
                    field.set(obj, Long.parseLong(entry.getValue()[0]));
                    continue;
                }
                if (fieldType == Float.class) {
                    field.set(obj, Float.parseFloat(entry.getValue()[0]));
                    continue;
                }
                if (fieldType == String.class) {
                    field.set(obj, entry.getValue()[0]);
                    continue;
                }
                System.err.println("不可转换类型: " + fieldType.getTypeName());
            } catch (NoSuchFieldException e) {
                System.err.println("注入属性失败， map对应属性名称为: " + entry.getKey());
            }
        }
        return obj;
    }

    /**
     * 根据指定field名称返回对应的key-value
     * @param clz 对象的类型
     * @param obj 取值对象
     * @param fields 取值的field, 如果为空则返回全部的key-value
     * @param <T> 对象的类型
     * @return map<String, Object>
     * @throws NoSuchFieldException 当field中的值不存在于对象类型中
     */
    public static <T> Map<String, Object> getFieldMap(Class<T> clz, T obj, String ... fields) throws NoSuchFieldException {
        Map<String, Object> map = new HashMap<>();
        if (fields == null || fields.length == 0) {
            for (Field field : clz.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    map.put(field.getName(), field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return map;
        }
        for (String filed : fields) {
            Field f = clz.getDeclaredField(filed);
            f.setAccessible(true);
            try {
                map.put(filed, f.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
