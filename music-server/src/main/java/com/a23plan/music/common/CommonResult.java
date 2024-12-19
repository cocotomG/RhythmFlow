package com.a23plan.music.common;

import lombok.Data;

/**
 * @Author:  err
 * @Description:
 * @return:
 * @Date:  2024/6/11 13:40
 */
@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){};

    protected CommonResult(long code,String message,T data){
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static<T> CommonResult<T> success(){
        return new CommonResult<T>(CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMessage(), null);
    }

    public static<T> CommonResult<T> success(T data){
        return new CommonResult<T>(CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMessage(), data);
    }

    public static<T> CommonResult<T> success(String message){
        return new CommonResult<T>(CommonCode.SUCCESS.getCode(),message, null);
    }

    public static<T> CommonResult<T> success(String message,T data){
        return new CommonResult<T>(CommonCode.SUCCESS.getCode(),message, data);
    }

    public static<T> CommonResult<T> faild(String message){
        return new CommonResult<T>(CommonCode.FAILED.getCode(), message,null);
    }
    public static<T> CommonResult<T> faild(){
        return new CommonResult<T>(CommonCode.FAILED.getCode(),CommonCode.FAILED.getMessage(), null);
    }

    public static<T> CommonResult<T> forbidden(){
        return new CommonResult<T>(CommonCode.FORBIDDEN.getCode(), CommonCode.FORBIDDEN.getMessage(), null);
    }
}
