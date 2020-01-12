package com.will.asgard.thor.model.soundsystem;

import lombok.Data;

import java.util.List;

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
