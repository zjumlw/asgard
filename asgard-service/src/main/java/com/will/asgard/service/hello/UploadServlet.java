package com.will.asgard.service.hello;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class UploadServlet extends HttpServlet {
    private String filePath;
    private String tempFilePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        filePath = config.getInitParameter("filePath");
        tempFilePath = config.getInitParameter("tempFilePath");

//        filePath = getServletContext().getRealPath(filePath);
//        tempFilePath = getServletContext().getRealPath(tempFilePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try (PrintWriter outNet = resp.getWriter()) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(4 * 1024);
            factory.setRepository(new File(tempFilePath));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(4 * 1024 * 1024);
            List<FileItem> items = upload.parseRequest(req);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    processFormField(item, outNet);
                } else {
                    processUploadedFile(item, outNet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processFormField(FileItem item, PrintWriter writer) {
        String name = item.getFieldName();
        String value = item.getString();
        writer.println(name + ": " + value + "\r\n");
    }

    private void processUploadedFile(FileItem item, PrintWriter writer) throws Exception {
        String filename = item.getName();
        int index = filename.lastIndexOf("\\");
        filename = filename.substring(index + 1);
        long fileSize = item.getSize();

        if ("".equals(filename) && fileSize == 0) {
            return;
        }

        File uploadedFile = new File(filePath + "/" + filename);
        item.write(uploadedFile);
        writer.println(filename + " is saved");
        writer.println("The size of " + filename + " is " + fileSize + "\r\n");
    }
}
