package com.will.asgard.service.hello;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>HELLOWORLD!!</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World Servlet!!!</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
