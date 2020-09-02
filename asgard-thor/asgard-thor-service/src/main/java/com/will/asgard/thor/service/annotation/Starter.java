package com.will.asgard.thor.service.annotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName Starter
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-01 17:41
 * @Version 1.0
 **/
@Component
class Starter {

    //    @MethodInvokeLink(methodName = "start")
    public void start(MyContext myContext) {
        System.out.println("start");
        middle(myContext);
    }

    //    @MethodInvokeLink(methodName = "middle")
    public void middle(MyContext myContext) {
        System.out.println("middle");
        end(myContext);
    }

    public void end(MyContext myContext) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("index: ").append(i)
                    .append(", ClassName: ").append(elements[i].getClassName())
                    .append(", Method Name: " + elements[i].getMethodName());

            System.out.println(buffer.toString());
        }
        System.out.println("end");
    }
}
