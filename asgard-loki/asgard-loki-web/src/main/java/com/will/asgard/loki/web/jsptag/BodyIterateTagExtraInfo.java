package com.will.asgard.loki.web.jsptag;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class BodyIterateTagExtraInfo extends TagExtraInfo {
    @Override
    public VariableInfo[] getVariableInfo(TagData data) {
        return new VariableInfo[]{
                new VariableInfo(data.getId(), "java.lang.String", true, VariableInfo.NESTED)
        };
    }
}
