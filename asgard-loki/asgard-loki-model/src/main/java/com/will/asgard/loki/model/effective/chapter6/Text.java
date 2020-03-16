package com.will.asgard.loki.model.effective.chapter6;

import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.Sets;
import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName Text
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-11 00:27
 * @Version 1.0
 **/
public class Text {
	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	private Set<Style> appliedStyle = Sets.newHashSet();

	public void applyStyle(Set<Style> styles) {
		appliedStyle.addAll(styles);
	}

	public void status() {
		System.out.println("applied style: " + GsonUtil.toJson(appliedStyle));
	}

	public static void main(String[] args) {
		EnumSet<Style> res = EnumSet.of(Style.UNDERLINE, Style.BOLD);
		System.out.println(res);

		Set<Style> set = Sets.newHashSet(Style.BOLD, Style.ITALIC);
		Text text = new Text();
		text.applyStyle(set);
		text.status();
	}
}
