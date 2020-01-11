package com.will.asgard.common.core.serviceprovicer;

/**
 * Created by WillMao on 19-1-18
 *
 * Service provider interface 提供者负责创建其服务的实例
 */
public interface Provider {
	Service newService();
}
