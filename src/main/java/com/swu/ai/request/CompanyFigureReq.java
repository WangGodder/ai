package com.swu.ai.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/3/10
 */
@Setter
@Getter
public class CompanyFigureReq implements Serializable {
    private Integer year;
    private Integer quarter;
    private String companyname;
    private String industry;
    private String region;
    private Long id;
}
