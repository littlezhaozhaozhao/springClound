package com.myspring.hystrix;


import com.netflix.hystrix.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/*
这是自定义的HystrixCommand
 */
public class MyHystrixCommand  extends HystrixCommand {
    private RestTemplate restTemplate;
//    自定义Hystrix Command 必须要实现
    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Object run() throws Exception {
        ResponseEntity<String> restEntity = restTemplate.getForEntity("http://PRIVIDER/hello", String.class);
        return restEntity.getBody();
    }

    @Override
    protected String getFallback() {
        return "这是自定义hystrixCommand的异常处理方法";
    }
}