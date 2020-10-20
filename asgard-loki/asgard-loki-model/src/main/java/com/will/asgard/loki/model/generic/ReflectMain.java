package com.will.asgard.loki.model.generic;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-20 17:55
 * @Version 1.0
 **/
public class ReflectMain {

    public static <T> T createInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        A a = createInstance(A.class);
        a.setName("aa");
        a.hello();

        Class<? extends A> aClass = a.getClass();
        A a1 = createInstance(aClass);
        a1.hello();

        B b = createInstance(B.class);
    }
}

class A {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void hello() {
        System.out.println("a class, name: " + name);
    }
}

class B {}
