package com.will.asgard.service.hello;

import com.google.common.collect.Lists;
import com.will.asgard.common.model.po.UserPO;
import com.will.asgard.common.mysql.factory.DAOFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet do nothing");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginPath = "views/login.jsp";
        String userId = req.getParameter("userid");
        String userPassword = req.getParameter("userpass");
        System.out.println("userid: " + userId + ", password: " + userPassword);

        String targetUrl = (String) req.getSession().getAttribute("targetUrl");
        System.out.println("targetUrl: " + targetUrl);

        List<String> info = Lists.newArrayList();
        if (StringUtils.isBlank(userId)) {
            info.add("用户id不能为空");
        }
        if (StringUtils.isBlank(userPassword)) {
            info.add("密码不能为空");
        }

        boolean loginSuccess = false;
        if (info.size() == 0) {
            UserPO userPO = new UserPO();
            userPO.setUserId(userId);
            userPO.setPassword(userPassword);

            try {
                if (DAOFactory.getIUserDAOInstance().findLogin(userPO)) {
                    info.add("用户登录成功,欢迎" + userPO.getName() + "光临");
                    HttpSession ses = req.getSession();
                    ses.setAttribute("userid", userId);
                    loginSuccess = true;
                } else {
                    info.add("用户登录失败,错误的用户名或密码");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        req.setAttribute("info", info);

        if (loginSuccess) {
            System.out.println("Login success!!!");
            if (StringUtils.isNotBlank(targetUrl)){
                String location = req.getContextPath() + targetUrl;
                System.out.println("redirect location: " + location);
                req.getSession().removeAttribute("targetUrl");
                System.out.println("Session remove attribute targetUrl: " + targetUrl);
                resp.sendRedirect(location);
//                req.getRequestDispatcher(targetUrl).forward(req, resp);
            } else {
                resp.sendRedirect("/asgard/index.html");
//                req.getRequestDispatcher("/index.html").forward(req, resp);
            }

        } else {
            System.out.println("Login failed");
            req.getRequestDispatcher(loginPath).forward(req, resp); // 跳转
        }
    }

}
