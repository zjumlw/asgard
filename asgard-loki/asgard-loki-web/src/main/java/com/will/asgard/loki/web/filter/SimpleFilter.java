package com.will.asgard.loki.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParam = filterConfig.getInitParameter("ref");
        System.out.println("==> 过滤器初始化，初始化参数 = " + initParam);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("==> 执行doFilter之前");
        chain.doFilter(request, response);
        System.out.println("==> 执行doFilter之后");
    }

    @Override
    public void destroy() {
        System.out.println("==> 过滤器销毁");
    }
}
