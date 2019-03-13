package com.swu.ai.Result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/13
 */
@Setter
@Getter
public class EvaluateDetailTable implements Serializable {
    private List<String> titles;
    private List<String> fields;
}
