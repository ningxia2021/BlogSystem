package com.example.blog.common;

import org.springframework.util.StringUtils;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
//    成功信息
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
//    失败信息
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
//    成功状态码
    private static final int RESULT_CODE_SUCCESS = 200;
//    服务器错误码
    private static final int RESULT_CODE_SERVER_ERROR = 500;

//    返回默认成功信息
    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

//    返回自定义成功信息
    public static Result genSuccessResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

//    返回默认成功状态+数据
    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

//    返回失败结果+自定义信息
    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        if (StringUtils.isEmpty(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

//    返回自定义错误信息
    public static Result genErrorResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
