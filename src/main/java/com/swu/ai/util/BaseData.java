package com.swu.common.chart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/1/1
 */
@Setter
@Getter
public class BaseData<T> {
    private String title;
    private List<String> labels;
    private List<List<T>> datas;
    private List<String> datasetLabels;

}
