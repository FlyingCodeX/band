package com.xiefei.bandcommon.exception;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;

/**
 * @author faye
 * @create 2021-09-2021/9/1-17:21
 */
public class Asserts {
    public static void failed(String message) {
        throw new ApiException(message);
    }
}
