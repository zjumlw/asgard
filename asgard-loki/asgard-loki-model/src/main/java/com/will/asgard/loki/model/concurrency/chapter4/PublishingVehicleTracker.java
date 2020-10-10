package com.will.asgard.loki.model.concurrency.chapter4;

import java.util.Collections;
import java.util.Map;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-04 9:39 下午
 * @Version 1.0
 */
class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = locations;
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
        }
        locations.get(id).set(x, y);
    }
}
