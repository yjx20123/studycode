package com.yang.blog.response;




public enum ResonseState {
    SUCCESS(true,20000,"操作成功"),
    FAILED(false,40000,"操作失败"),
    LOGIN_FAILED(false,20001,"登录失败"),
    GET_RESOURE_FAILED(false,40001,"获取失败");
    private int code;
    private String message;
    private boolean success;

    ResonseState(boolean success,int code, String message) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    ResonseState() {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
