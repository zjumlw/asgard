package com.will.asgard.common.serviceprovicer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WillMao on 19-1-18
 */
public class Services {
	// Prevents instantiation
	private Services() {
	}

	// Maps service names to services
	private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

}
