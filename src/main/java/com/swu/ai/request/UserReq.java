package com.swu.ai.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
/**
 * @author mhp
 * @date 2019/1/17
 */
public class UserReq implements Serializable {
    private String userId;
    private String pwd;
}
