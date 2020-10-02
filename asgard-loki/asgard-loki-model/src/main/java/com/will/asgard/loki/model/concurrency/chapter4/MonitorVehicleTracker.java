package com.will.asgard.loki.model.concurrency.chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-01 8:46 下午
 * @Version 1.0
 */
@ThreadSafe
class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        // 返回new的对象，防止对象逃逸被外部更改
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocations(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (Map.Entry<String, MutablePoint> entry : m.entrySet()) {
            result.put(entry.getKey(), new MutablePoint(entry.getValue()));
        }
        return Collections.unmodifiableMap(result);
    }

    public static void main(String[] args) {
        Map<String, MutablePoint> locations = new HashMap<>();
        locations.put("1", new MutablePoint(1, 2));
        MonitorVehicleTracker tracker = new MonitorVehicleTracker(locations);

        String id = "1";
        MutablePoint loc = tracker.getLocation(id);
        System.out.println("id=" + id + ", x=" + loc.x + ", y=" + loc.y);

        tracker.setLocations(id, 2, 3);
        loc = tracker.getLocation(id);
        System.out.println("id=" + id + ", x=" + loc.x + ", y=" + loc.y);
    }
}
