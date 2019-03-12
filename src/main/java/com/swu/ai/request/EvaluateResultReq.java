package com.swu.ai.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/3/11
 */
@Setter
@Getter
public class EvaluateResultReq extends CompanyInputReq implements Serializable {
//    private String industry;
//    private String region;
//    private Integer beginYear;
//    private Integer endYear;
//    private Integer beginQuarter;
//    private Integer endQuarter;
    private String evaluateType;
    private Long companyId;
    private Long figureId;
}
