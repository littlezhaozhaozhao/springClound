package com.myspringcloud.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//自定义异常处理 controller
@RestController
public class MyErroeController   implements ErrorController {
    @Override
    public String getErrorPath() {
        System.out.println("进入异常处理类");
        return "/error";  //转发的路径
    }
    @RequestMapping("/error")
    public String error() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        ZuulException   zuu=(ZuulException) currentContext.getThrowable();
        System.out.println("进入异常处理类");
        return zuu.nStatusCode+"--"+zuu.getMessage();
    }
}
