package com.will.asgard.service.jsptag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class IterateTag extends TagSupport {
    private String name;
    private String scope;
    private String id;
    private Iterator<?> iter;

    @Override
    public int doStartTag() throws JspException {
        Object value = null;
        if ("page".equals(scope)) {
            value = pageContext.getAttribute(name, PageContext.PAGE_SCOPE);
        } else if ("request".equals(scope)) {
            value = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
        } else if ("session".equals(scope)) {
            value = pageContext.getAttribute(name, PageContext.SESSION_SCOPE);
        } else {
            value = pageContext.getAttribute(name, PageContext.APPLICATION_SCOPE);
        }

        if (value instanceof List<?>) {
            iter = ((List) value).iterator();
            if (iter.hasNext()) {
                String valueTmp = (String) iter.next();
                System.out.println("doStartTag, page set attribute, name: " + id + ", value: " + valueTmp);
                pageContext.setAttribute(id, valueTmp);
                return TagSupport.EVAL_BODY_INCLUDE;
            } else {
                return TagSupport.SKIP_BODY;
            }
        } else {
            return TagSupport.SKIP_BODY;
        }
    }

    @Override
    public int doAfterBody() throws JspException {
        if (iter.hasNext()) {
            String value = (String) iter.next();
            System.out.println("doAfterBody, page set attribute, name: " + id + ", value: " + value);
            pageContext.setAttribute(id, value);
            return TagSupport.EVAL_BODY_AGAIN;
        } else {
            return TagSupport.SKIP_BODY;
        }
    }
}
