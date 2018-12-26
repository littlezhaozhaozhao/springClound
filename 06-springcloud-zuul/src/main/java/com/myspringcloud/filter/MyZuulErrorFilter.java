package com.myspringcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//使用自定义异常处理接口
//@Component
public class MyZuulErrorFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
//        遇到异常执行的 filter
    }


    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        context.setSendZuulResponse(false); //终止转发，返回响应报文
        context.setResponseStatusCode(401);
        try {
            response.getWriter().print("遇到异常");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
