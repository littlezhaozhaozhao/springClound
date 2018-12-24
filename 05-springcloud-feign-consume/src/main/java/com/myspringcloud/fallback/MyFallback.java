package com.myspringcloud.fallback;

import com.myspringcloud.service.HelloService;
import org.springframework.stereotype.Component;
//将myFallback 变成 spring boot管理的一个类
//自定义 熔断回调 类需要继承 feign的service接口
@Component
public class MyFallback  implements HelloService {
    @Override
    public String hello() {
        return "myFallback   错误熔断";
    }
}
