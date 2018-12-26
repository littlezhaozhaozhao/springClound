package com.myspringcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
//        在什么生命周期执行过滤器  pre 表示治安
    }

    @Override
    public int filterOrder() {
        return 0;
//        执行顺序 越小执行越早
    }

    @Override
    public boolean shouldFilter() {
        return true;
//        是否使用该filter
    }

    @Override
    public Object run() throws ZuulException {
//        业务逻辑处理模块  返回值暂时没有用
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("accessToken");
        int a=10/0;
        if (token==null){
            HttpServletResponse response = context.getResponse();
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            context.setSendZuulResponse(false); //终止转发，返回响应报文
            context.setResponseStatusCode(400);
            context.setResponseBody("请求失败");
        }else {
            //这里可以进一步校验token的合法性、时效性，甚至对报文进行校验
            context.setSendZuulResponse(true); //将请求往后转发
            context.setResponseStatusCode(200);
        }
        return null;

    }
}
