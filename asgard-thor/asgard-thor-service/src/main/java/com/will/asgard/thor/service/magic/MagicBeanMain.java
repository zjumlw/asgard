package com.will.asgard.thor.service.magic;

import com.will.asgard.thor.model.magic.MagicBean;
import com.will.asgard.thor.model.magic.MagicBeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MagicBeanMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MagicBeanConfig.class);
        MagicBean magicBean = (MagicBean) context.getBean("magicBean");
        magicBean.magic();
    }
}
