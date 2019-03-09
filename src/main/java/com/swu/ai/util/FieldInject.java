package com.swu.ai.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
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
}
