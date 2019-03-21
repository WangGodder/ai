package com.swu.ai.request;

import com.swu.ai.entity.EvaluateResult;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author: godder
 * @date: 2019/3/11
 */
@Setter
@Getter
public class EvaluateResultReq extends CompanyInputReq implements Serializable, Cloneable {
//    private String industry;
//    private String region;
//    private Integer beginYear;
//    private Integer endYear;
//    private Integer beginQuarter;
//    private Integer endQuarter;
    private String evaluateType;
    private Long companyId;
    private Long figureId;

    @Override
    public EvaluateResultReq clone() throws CloneNotSupportedException {
        EvaluateResultReq result = new EvaluateResultReq();
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
