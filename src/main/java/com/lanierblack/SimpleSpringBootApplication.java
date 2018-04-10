package com.lanierblack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication

@ComponentScan
@MapperScan("com.lanierblack.mapper") //配置扫描mapper接口的地址
public class SimpleSpringBootApplication {
	private static final Logger logger = LogManager.getLogger(SimpleSpringBootApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootApplication.class, args);
	}



	/**
	 * protobuf HttpMessageConverter, 解析 protobuf 数据
	 */
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}
}
