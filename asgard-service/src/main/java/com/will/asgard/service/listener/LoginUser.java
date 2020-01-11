package com.will.asgard.service.listener;

import lombok.Data;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@Data
public class LoginUser implements HttpSessionBindingListener {
    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("==> Session bound LoginUser, name: " + this.getName()
                + ", sessionId: " + event.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("==> Session unbound LoginUser, name: " + this.getName()
                + ", sessionId: " + event.getSession().getId());
    }
}
