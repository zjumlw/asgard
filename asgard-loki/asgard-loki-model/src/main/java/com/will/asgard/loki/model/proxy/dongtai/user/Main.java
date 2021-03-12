package com.will.asgard.loki.model.proxy.dongtai.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;

import com.will.asgard.loki.model.proxy.dongtai.user.impl.UserDaoImpl;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-11 下午7:59
 * @Version 1.0
 */
public class Main {

    private static final Class<?>[] constructorParams =
            { UserDao.class };

    public static void main(String[] args) throws NoSuchMethodException {
        Object target = new UserDaoImpl();
        TransactionHandler handler = new TransactionHandler(target);
        UserDao userDao = (UserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        userDao.save();

        Class<?>[] interfaces = Child.class.getInterfaces();
        for (Class<?> aClass : interfaces) {
            System.out.println(aClass.getName());
        }

        System.out.println("constructor");
        Constructor<?>[] constructors = Child.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        Class<?> cl = UserDaoImpl.class;
        final Constructor<?> cons = cl.getConstructor(constructorParams);
        System.out.println(cons);
    }

    private static class Father {
        public Father(String name) {
            this.name = name;
        }

        private String name;
    }

    private interface InnerInterface {
        void test();
    }

    private interface AnotherInnerInterface {
        void hello();
    }

    private static class Child extends Father implements InnerInterface, AnotherInnerInterface {

        public Child(String name) {
            super(name);
        }

        @Override
        public void test() {
            System.out.println("test");
        }

        @Override
        public void hello() {
            System.out.println("hello");
        }
    }
}
