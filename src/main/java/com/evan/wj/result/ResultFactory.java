package com.evan.wj.result;

import com.evan.wj.env.WJConstants;

public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buildResult(WJConstants.ResultCode.SUCCESS.toString(), "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(WJConstants.ResultCode.FAIL.toString(), message, null);
    }

    public static Result buildResult(WJConstants.ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.toString(), message, data);
    }

    public static Result buildResult(String resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
