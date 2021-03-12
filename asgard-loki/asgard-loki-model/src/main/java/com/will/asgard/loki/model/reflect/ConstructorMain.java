package com.will.asgard.loki.model.reflect;

import java.lang.reflect.Constructor;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-20 下午4:00
 * @Version 1.0
 */
public class ConstructorMain {

    public static void main(String[] args) throws Exception {
        Class<?>[] classes = new Class[]{String.class, int.class};
        Solution solution1 = Solution.class.getConstructor(classes).newInstance("hello", 10);
        System.out.println(solution1.getName());
        System.out.println(solution1.getNum());

        Solution solution2 = solution1.getClass().getConstructor(String.class).newInstance("str");
        System.out.println(solution2.getName());
        System.out.println(solution2.getNum());

        Solution solution3 = (Solution) Class.forName("com.will.asgard.loki.model.reflect.Solution").getConstructor().newInstance();
        System.out.println(solution3.getName());

        Constructor<?>[] constructors = Solution.class.getConstructors();
        System.out.println(constructors.length);
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
