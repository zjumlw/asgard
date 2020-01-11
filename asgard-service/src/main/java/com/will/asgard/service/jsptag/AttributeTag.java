package com.will.asgard.service.jsptag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

@Getter
@Setter
public class AttributeTag extends TagSupport {
    private String name;
    private String scope;

    @Override
    public int doStartTag() throws JspException {
        Object value = null;
        if ("page".equals(this.scope)) {
            value = super.pageContext
                    .getAttribute(name, PageContext.PAGE_SCOPE);
        } else if ("request".equals(this.scope)) {
            value = super.pageContext
                    .getAttribute(name, PageContext.REQUEST_SCOPE);
        } else if ("session".equals(this.scope)) {
            value = super.pageContext
                    .getAttribute(name, PageContext.SESSION_SCOPE);
        } else {
            value = super.pageContext
                    .getAttribute(name, PageContext.APPLICATION_SCOPE);
        }

        System.out.println("AttributeTag#doStartTag, value: " + value);

        if (value == null) {
            return TagSupport.SKIP_BODY;
        } else {
            System.out.println("name: " + name + ", scope: " + scope + ", value: " + value);
            return TagSupport.EVAL_BODY_INCLUDE;
        }
    }
}
