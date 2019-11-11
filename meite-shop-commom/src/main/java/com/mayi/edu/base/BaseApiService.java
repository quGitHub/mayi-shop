package com.mayi.edu.base;


import org.springframework.stereotype.Component;

public class BaseApiService<T> {

    public BaseResponse<T> setResultError(String code,String msg ){
       return setResult(code,msg,null);
    }

    public BaseResponse<T> setResultSuccess(String code,String msg,T t ){
        return setResult(code,msg,t);
    }

    public BaseResponse<T> setResult(String code, String msg,T t ){
        return new BaseResponse(code ,msg, t);
    }

}
