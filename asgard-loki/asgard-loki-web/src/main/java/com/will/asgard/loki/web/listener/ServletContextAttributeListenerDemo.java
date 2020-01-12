package com.will.asgard.loki.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("==> 增加属性 --> name: " + event.getName() + ", value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("==> 删除属性 --> name: " + event.getName() + ", value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("==> 替换属性 --> name: " + event.getName() + ", value: " + event.getValue());
    }
}
