package com.will.asgard.service.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListenerDemo implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("==> Request initialized, http://" + sre.getServletRequest().getRemoteAddr()
                + sre.getServletContext().getContextPath());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("==> Request destroyed, http://" + sre.getServletRequest().getRemoteAddr()
                + sre.getServletContext().getContextPath());
    }
}
