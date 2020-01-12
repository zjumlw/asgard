package com.will.asgard.loki.web.hello;


import com.will.asgard.loki.model.entity.vo.DeptVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ELServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptVO deptVO = new DeptVO();
        deptVO.setNumber(10);
        deptVO.setName("CompanyWill");
        deptVO.setLocation("HZ");
        req.setAttribute("deptinfo", deptVO);
        req.getRequestDispatcher("views/dept_info.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
