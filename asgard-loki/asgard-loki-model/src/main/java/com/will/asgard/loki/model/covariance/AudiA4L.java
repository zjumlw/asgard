package com.will.asgard.loki.model.covariance;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-19 11:07 下午
 * @Version 1.0
 */
public class AudiA4L extends AudiCar {
    @Override
    void drive() {
        System.out.println("Drive Audi A4L");
    }

    public static void main(String[] args) {
        AudiA4L a4L = new AudiA4L();
        a4L.drive();
    }
}
