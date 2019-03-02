package com.swu.ai.Result;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ResultBase {

    public static int SUCCESS = 1; //成功
    public static int FAILURE = 0; //失败

    public ResultBase() {
        this.status = FAILURE;
    }

    private int status;
    private String message;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
