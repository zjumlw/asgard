package com.will.asgard.loki.web.jsptag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class SimpleDateTag extends SimpleTagSupport {
    private String format;

    @Override
    public void doTag() throws JspException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            getJspContext().getOut().write(sdf.format(new Date()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
