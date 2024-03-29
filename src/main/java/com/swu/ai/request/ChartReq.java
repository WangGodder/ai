package com.swu.ai.request;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author: godder
 * @date: 2019/3/15
 */
@Setter
@Getter
public class ChartReq extends EvaluateResultReq implements Serializable {
    private String figureShow;

    @Override
    public ChartReq clone() throws CloneNotSupportedException {
        ChartReq result = new ChartReq();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                field.set(result, field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
