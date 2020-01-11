package com.will.asgard.common.biz.myspring.concert;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.google.common.collect.Lists;
import com.will.asgard.common.soundsystem.BlankDisc;
import com.will.asgard.common.soundsystem.CompactDisc;

@Configuration
@EnableAspectJAutoProxy // 启动 AspectJ 自动代理
public class TrackCounterConfig {

	@Bean
	public CompactDisc sgtPeppers() {
		BlankDisc cd = new BlankDisc();
		cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
		cd.setArtist("The Beatles");
		List<String> tracks = Lists.newArrayList();
		tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
		tracks.add("With a Litter Help from My Friends");
		tracks.add("Lucy in the Sky with Diamonds");
		tracks.add("Getting Better");
		tracks.add("Fixing a Hole");

		cd.setTracks(tracks);
		return cd;
	}

	public static void main(String[] args) {
		Thread t = new Thread(() -> System.out.println("pong"));

		t.start();
		System.out.println("ping");
	}


}
