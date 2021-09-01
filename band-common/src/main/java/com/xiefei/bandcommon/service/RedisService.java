package com.xiefei.bandcommon.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author faye
 * @create 2021-09-2021/9/1-16:31
 */
@Service
public interface RedisService {
    void set(String key, Object value,long time);

    void set(String key,Object value);

    Object get(String key);

    Boolean del(String key);

    Long del(List<String> keys);

    Boolean expire(String key,long time);


}
