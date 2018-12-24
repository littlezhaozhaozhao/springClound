package com.myspring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class Application8090 {

	public static void main(String[] args) {
		SpringApplication.run(Application8090.class, args);
	}
}
