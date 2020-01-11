package com.will.asgard.service.jsptag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class BodyIterateTag extends BodyTagSupport {
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
                pageContext.setAttribute(id, iter.next());
                return BodyTagSupport.EVAL_BODY_BUFFERED;
            } else {
                return BodyTagSupport.SKIP_BODY;
            }
        } else {
            return BodyTagSupport.SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        if (bodyContent != null) {
            try {
                bodyContent.writeOut(getPreviousOut());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return BodyTagSupport.EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (iter.hasNext()) {
            pageContext.setAttribute(id, iter.next());
            return BodyTagSupport.EVAL_BODY_AGAIN;
        } else {
            return BodyTagSupport.SKIP_BODY;
        }
    }
}
