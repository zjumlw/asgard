package com.will.asgard.admin.demo.enumdemo;

/**
 * Created by WillMao on 18-10-30
 */
enum Signal {
	GREEN, YELLOW, RED
}

public class TrafficLight {
	Signal color = Signal.RED;

	public void change() {
		switch (color) {
		case GREEN:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
			break;
		case RED:
			color = Signal.GREEN;
			break;
		}
	}

	@Override
	public String toString() {
		return "TrafficLight{" + "color=" + color + '}';
	}

	public static void main(String[] args) {
		TrafficLight trafficLight = new TrafficLight();
		for (int i = 0; i < 10; i++) {
			System.out.println(trafficLight);
			trafficLight.change();
		}
	}
}
