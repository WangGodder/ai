package com.swu.ai.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/3/7
 */
@Setter
@Getter
public class CompanyInputReq implements Serializable {
    private String industry;
    private String region;
    private Integer beginYear = 0;
    private Integer endYear = 10000;
    private Integer beginQuarter = 1;
    private Integer endQuarter = 4;

    @Override
    public String toString() {
        return "CompanyInputReq{" +
                "industry='" + industry + '\'' +
                ", region='" + region + '\'' +
                ", beginYear=" + beginYear +
                ", endYear=" + endYear +
                ", beginQuarter=" + beginQuarter +
                ", endQuarter=" + endQuarter +
                '}';
    }
}
