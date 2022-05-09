package com.evan.wj.result;

import lombok.Data;

@Data
public class Result {
    // 响应码
    private String code;

    // 消息
    private String message;

    // 数据
    private Object data;

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
