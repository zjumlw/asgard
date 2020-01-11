package com.will.asgard.admin.demo.enumdemo;

/**
 * Created by WillMao on 18-10-29
 */
enum RainbowColor {
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

public class RainbowColorDemo {

	public static void main(String[] args) {
		for (RainbowColor rainbowColor : RainbowColor.values()) {
			System.out.println(rainbowColor + " " + rainbowColor.ordinal() + " "
					+ rainbowColor.equals(RainbowColor.GREEN) + " " + rainbowColor.getDeclaringClass());
		}

		System.out.println();

		for (String s : "RED BLUE GREEN".split(" ")) {
			RainbowColor rainbowColor = RainbowColor.valueOf(s);
			System.out.println(rainbowColor);
		}
	}

}