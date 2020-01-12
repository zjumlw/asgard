package com.will.asgard.loki.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("==> Request attribute added, name: " + srae.getName() + ", value: " + srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("==> Request attribute removed, name: " + srae.getName() + ", value: " + srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("==> Request attribute replaced, name: " + srae.getName() + ", value: " + srae.getValue());
    }
}
