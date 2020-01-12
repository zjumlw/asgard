package com.will.asgard.loki.web.hello;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("Cookie name: " + cookie.getName());
                out.println("Cookie value: " + cookie.getValue());
                out.println("Max Age: " + cookie.getMaxAge() + "\r\n");
            }
        } else {
            out.println("No cookie.");
        }

        resp.addCookie(new Cookie("cookieName" + count, "cookieValue" + count));
        count++;
    }
}
