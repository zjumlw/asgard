package com.will.asgard.service.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==> init LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession ses = req.getSession();
        System.out.println("==> session userid: " + ses.getAttribute("userid"));

        if (ses.getAttribute("userid") != null
                || "/loginServlet".endsWith(req.getServletPath())) {
            System.out.println("==> login success or loginServlet");
            chain.doFilter(request, response);
        } else {
            System.out.println("==> login failed");
            String targetUrl = (String) ses.getAttribute("targetUrl");
            if (StringUtils.isBlank(targetUrl)) {
                String queryString = req.getQueryString();
                if (StringUtils.isNoneBlank(queryString)) {
                    targetUrl = req.getServletPath() + "?" + req.getQueryString();
                } else {
                    targetUrl = req.getServletPath();
                }
                System.out.println("Session set attribute targetUrl: " + targetUrl);
                ses.setAttribute("targetUrl", targetUrl);
            }
            req.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
