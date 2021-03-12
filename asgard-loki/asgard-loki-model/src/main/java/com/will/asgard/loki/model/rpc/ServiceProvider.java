package com.will.asgard.loki.model.rpc;

import java.io.IOException;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-12-25 上午11:59
 * @Version 1.0
 */
public class ServiceProvider {

    public static void main(String[] args) throws IOException {
        // 服务提供者暴露接口
        AobingService service = new AobingServiceImpl();
        System.out.println("服务接口已暴露");
        AobingRpcFramework.export(service, 2333);
    }
}
