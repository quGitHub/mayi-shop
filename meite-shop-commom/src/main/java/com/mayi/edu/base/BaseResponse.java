package com.mayi.edu.base;

public class BaseResponse<T>  {


    private String code;

    private String msg;

    private T t;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public BaseResponse(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }
}
