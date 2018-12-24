package com.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//feign 声明式客户端注解
@EnableFeignClients
public class ApplicationConsume8082 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConsume8082.class, args);
	}

}

