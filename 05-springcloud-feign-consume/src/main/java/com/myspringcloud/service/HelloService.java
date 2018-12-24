package com.myspringcloud.service;


import com.myspringcloud.fallback.MyFallback;
import com.myspringcloud.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//使用feign 客户端注解绑定服务提供者的在eureka注册中心中的名字
@FeignClient(name="privider",fallbackFactory = MyFallbackFactory.class)
public interface HelloService   {
    /**
     * 声明的这个方法就是服务提供者的提供的方法
     * requestMapping  就是方法的访问
     * @return
     */
    @RequestMapping("hello")
    public  String  hello();
}
