package com.will.asgard.common.core.soundsystem;

import java.util.List;

import lombok.Data;

@Data
public class BlankDisc implements CompactDisc {
	private String title;
	private String artist;
	private List<String> tracks;

	@Override
	public void play() {

	}

	@Override
	public void playTrack(int trackNumber) {

	}
}
