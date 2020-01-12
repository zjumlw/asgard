package com.will.asgard.loki.web.jsptag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DynamicAddTag extends SimpleTagSupport implements DynamicAttributes {
    private Map<String, Float> num = new HashMap<>();

    @Override
    public void doTag() throws JspException, IOException {
        Float sum = 0.0f;

        Iterator<Map.Entry<String, Float>> iter = num.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Float> value = iter.next();
            sum += value.getValue();
        }

        getJspContext().getOut().write(sum + "");
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        num.put(localName, Float.valueOf(value.toString()));
    }
}
