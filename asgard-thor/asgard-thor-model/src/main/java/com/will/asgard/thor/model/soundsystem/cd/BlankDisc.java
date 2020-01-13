package com.will.asgard.thor.model.soundsystem.cd;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
public class BlankDisc implements CompactDisc {
	private String title;
	private String artist;
	private List<String> tracks;

	@Override
	public void play() {
        System.out.println("Playing " + title + " by " + artist);
        if (!CollectionUtils.isEmpty(tracks)) {
            tracks.forEach(each -> System.out.println("- Track: " + each));
        }
	}

	@Override
	public void playTrack(int trackNumber) {

	}
}
