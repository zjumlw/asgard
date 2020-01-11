package com.will.asgard.service.hello;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ServerRedirectDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("username", "WillMao");
        req.setAttribute("info", "SONY");
        req.getServletContext().setAttribute("app", "Mi");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/get_info.jsp");
        requestDispatcher.forward(req, resp);
        log.info("server redirect demo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
