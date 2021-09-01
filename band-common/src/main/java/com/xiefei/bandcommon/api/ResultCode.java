package com.xiefei.bandcommon.api;

import lombok.Data;

/**
 * @author faye
 * @create 2021-09-2021/9/1-13:49
 */

public enum ResultCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;

    private String message;

    ResultCode(long code,String message){
        this.code = code;
        this.message = message;
    }

    public long getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

}
