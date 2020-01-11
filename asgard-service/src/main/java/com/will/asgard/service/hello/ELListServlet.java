package com.will.asgard.service.hello;

import com.will.asgard.common.core.model.vo.DeptVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ELListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptVO deptVO = new DeptVO();
        deptVO.setNumber(10);
        deptVO.setName("CompanyWill");
        deptVO.setLocation("HZ");

        DeptVO deptVO1 = new DeptVO();
        deptVO1.setNumber(10);
        deptVO1.setName("CompanyWill");
        deptVO1.setLocation("HZ");

        List<DeptVO> deptVOList = new ArrayList<>();
        deptVOList.add(deptVO);
        deptVOList.add(deptVO1);

        req.setAttribute("alldept", deptVOList);
        req.getRequestDispatcher("views/dept_list.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
