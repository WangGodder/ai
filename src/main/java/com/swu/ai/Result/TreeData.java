package com.swu.ai.Result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/14
 */
@Setter
@Getter
public class TreeData<T> {
    private String title;
    private String field;
    private T value;
    private List<TreeData<T>> children;

    public TreeData() {
    }

    public TreeData(String title, String field, T value) {
        this.title = title;
        this.field = field;
        this.value = value;
    }
}
