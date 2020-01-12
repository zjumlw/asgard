package com.will.asgard.loki.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String charSet;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.charSet = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("==> Set character encoding: " + this.charSet);
        request.setCharacterEncoding(this.charSet);
    }

    @Override
    public void destroy() {

    }
}
