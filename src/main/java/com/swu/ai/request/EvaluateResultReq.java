package com.swu.ai.request;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/3/11
 */
public class EvaluateResultReq implements Serializable {
    private String industry;
    private String region;
    private Integer beginYear;
    private Integer endYear;
    private Integer beginQuarter;
    private Integer endQuarter;
    private String evaluateType;
    private Long companyId;
    private Long figureId;
}
