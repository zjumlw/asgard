package com.will.asgard.loki.model.concurrency.chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.will.asgard.common.util.GsonUtil;

/**
 * @Description 委托给线程安全类的车辆追踪器
 * @Author maolingwei
 * @Date 2020-10-01 9:30 下午
 * @Version 1.0
 */
class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        Point point = unmodifiableMap.get(id);
        System.out.println(point.x + "," + point.y);

        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("Invalid vehicle name: " + id);
        }
        point = unmodifiableMap.get(id);
        System.out.println(point.x + "," + point.y);
    }

    public static void main(String[] args) {
        Map<String, Point> locations = new HashMap<>();
        locations.put("1", new Point(1, 2));
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(locations);

        String id = "1";
        Point location = tracker.getLocation(id);
        System.out.println("id=" + id + ",x=" + location.x + ",y=" + location.y);
        System.out.println("locations=" + GsonUtil.toJson(tracker.getLocations()));

        System.out.println("update location, id=" + id + ",x=" + 2 + ",y=" + 3);
        tracker.setLocation(id, 2, 3);
        location = tracker.getLocation(id);
        System.out.println("id=" + id + ",x=" + location.x + ",y=" + location.y);
        System.out.println("locations=" + GsonUtil.toJson(tracker.getLocations()));
    }
}
