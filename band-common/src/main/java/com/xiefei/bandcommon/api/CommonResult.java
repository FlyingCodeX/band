package com.xiefei.bandcommon.api;

import lombok.Data;

/**
 * @author faye
 * @create 2021-09-2021/9/1-13:42
 */
@Data
public class CommonResult<T> {

    private long code;

    private String message;

    private T data;

    protected CommonResult(){}

    protected CommonResult(long code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }


    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    public static <T> CommonResult<T> failed(){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    public static <T> CommonResult<T> failed(T data){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),data);
    }

    public static <T> CommonResult<T> failed(T data,String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,data);
    }




}
