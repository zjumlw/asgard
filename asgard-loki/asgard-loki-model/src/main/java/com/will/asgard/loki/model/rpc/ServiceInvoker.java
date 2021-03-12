package com.will.asgard.loki.model.rpc;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-12-25 上午11:59
 * @Version 1.0
 */
public class ServiceInvoker {

    public static void main(String[] args) {
        AobingService service = AobingRpcFramework.refer(AobingService.class, "127.0.0.1", 2333);
        System.out.println(service.hello("xiaomi"));
    }
}
