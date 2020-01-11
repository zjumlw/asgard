package com.will.asgard.service.hello;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {
    private String filePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        filePath = config.getInitParameter("filePath");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out;
        InputStream in;

        String fileName = req.getParameter("filename");
        System.out.println("download filename: " + fileName);
        req.getInputStream();
        if (StringUtils.isBlank(fileName)) {
            out = resp.getOutputStream();
            out.write("Please input filename.".getBytes());
            out.close();
            return;
        }

        String filePathName = filePath + "/" + fileName;
        System.out.println("filePathName: " + filePathName);
        in = new FileInputStream(filePathName);
        int length = in.available();

        resp.setContentType("application/force-download");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Length", String.valueOf(length));
        resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

        out = resp.getOutputStream();
        int bytesRead = 0;
        byte[] buffer = new byte[512];
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
    }
}
