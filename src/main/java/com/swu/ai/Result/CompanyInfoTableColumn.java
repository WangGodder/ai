package com.swu.ai.Result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/8
 */
@Setter
@Getter
public class CompanyInfoTableColumn {
    private List<String> fields;
    private List<String> titles;
    private List<String> headField;
    private List<String> headTitles;
    private List<String> firstRowTitles;
    private List<Integer> firstRowLength;
    private List<String> secondRowTitles;
    private List<Integer> secondRowLength;

    @Override
    public String toString() {
        return "CompanyInfoTableColumn{" +
                "fields=" + fields +
                ", titles=" + titles +
                ", headField=" + headField +
                ", headTtitles=" + headTitles +
                ", firstRowTitles=" + firstRowTitles +
                ", firstRowLength=" + firstRowLength +
                ", secondRowTitles=" + secondRowTitles +
                ", secondRowLength=" + secondRowLength +
                '}';
    }
}
