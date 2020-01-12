package com.will.asgard.loki.web.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("==> 增加属性 --> sessionId: " + event.getSession().getId() +", name: " + event.getName()
                + ", value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("==> 删除属性 --> sessionId: " + event.getSession().getId() +", name: " + event.getName()
                + ", value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("==> 替换属性 --> sessionId: " + event.getSession().getId() +", name: " + event.getName()
                + ", value: " + event.getValue());
    }
}
