package com.myspringcloud.fallback;

import com.myspringcloud.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 将这个类变成 spring boot 管理的一个类
 * 需要实现FallbackFactory接口并泛型成 feign serivce接口
 */
@Component
public class MyFallbackFactory  implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable throwable) {
      return  new HelloService() {
            @Override
            public String hello() {
                return  throwable.getMessage();
            }
        };
    }
}
