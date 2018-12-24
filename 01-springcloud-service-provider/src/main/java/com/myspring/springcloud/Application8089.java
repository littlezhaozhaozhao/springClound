package com.myspring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class Application8089 {

	public static void main(String[] args) {
		SpringApplication.run(Application8089.class, args);
	}
}
