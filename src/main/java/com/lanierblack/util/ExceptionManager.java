package com.lanierblack.util;

import com.lanierblack.common.CustomException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ExceptionManager {
    @Resource
    Environment environment;
    public CustomException getCustomError(String code) {
        return new CustomException(code, environment.getProperty(code));
    }
}
