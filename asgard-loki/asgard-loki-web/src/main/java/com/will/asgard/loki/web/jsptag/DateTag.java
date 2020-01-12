package com.will.asgard.loki.web.jsptag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {
    @Getter
    @Setter
    private String format;

    @Override
    public int doStartTag() throws JspException {
        SimpleDateFormat sdf = new SimpleDateFormat(this.format);
        try {
            super.pageContext.getOut().write(sdf.format(new Date()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return TagSupport.SKIP_BODY;
    }
}
