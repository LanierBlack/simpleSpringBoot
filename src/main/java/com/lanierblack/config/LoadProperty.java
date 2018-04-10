package com.lanierblack.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

 @Component
 @PropertySource(value = {"classpath:config/exception.properties"}, encoding = "UTF-8")
public class LoadProperty {

}
