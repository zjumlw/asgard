package com.will.asgard.loki.model.reflect;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-20 下午3:58
 * @Version 1.0
 */
public class NewInstanceMain {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 适用于无参构造方法
        Solution solution1 = Solution.class.newInstance();
        System.out.println(solution1.getName());

        Solution solution2 = solution1.getClass().newInstance();
        System.out.println(solution2.getName());

        Class<?> cl = Class.forName("com.will.asgard.loki.model.reflect.Solution");
        Solution solution3 = (Solution) cl.newInstance();
        solution3.setName("solution3");
        System.out.println(solution3.getName());
    }
}
