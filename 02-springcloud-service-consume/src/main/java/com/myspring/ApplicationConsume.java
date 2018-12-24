package com.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//eureka客户端注解
@EnableEurekaClient
//开启Hystrix 功能
@EnableCircuitBreaker
@SpringBootApplication
  //@SpringCloudApplication   这个注解可以替换 SpringBootApplication  和 EnableCircuitBreaker
public class ApplicationConsume {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsume.class, args);
    }
}
