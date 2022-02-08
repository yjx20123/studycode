package com.yang.blog.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ResponseResult {
    private boolean success;
    private int code;
    private String message;
    private Object data;

    public ResponseResult(boolean success, int code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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


    public Object setData(Object data) {
        this.data = data;
        return data;
    }

    public ResponseResult(ResonseState resonseState) {
        this.success = resonseState.isSuccess();
        this.code = resonseState.getCode();
        this.message = resonseState.getMessage();
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(ResonseState.SUCCESS);
    }

    public static ResponseResult SUCCESS(String message) {
        ResponseResult responseResult = new ResponseResult(ResonseState.SUCCESS);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult FAILED() {
        return new ResponseResult(ResonseState.FAILED);
    }

    public static ResponseResult FAILED(String message) {
        ResponseResult responseResult = new ResponseResult(ResonseState.FAILED);
        responseResult.setMessage(message);
        return responseResult;
    }
}
