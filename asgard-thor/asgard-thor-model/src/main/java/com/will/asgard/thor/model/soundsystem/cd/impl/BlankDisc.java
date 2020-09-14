package com.will.asgard.thor.model.soundsystem.cd.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;

import lombok.Data;

@Data
//@Component("blankDisc")
public class BlankDisc implements CompactDisc {
	private String title;
	private String artist;
	private List<String> tracks;

    public BlankDisc() {
    }

    public BlankDisc(@Value("${disc.title}") String title, @Value("${disc.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
	public void play() {
        System.out.println("Playing " + title + " by " + artist);
        if (!CollectionUtils.isEmpty(tracks)) {
            tracks.forEach(each -> System.out.println("- Track: " + each));
        }
	}

	@Override
	public void playTrack(int trackNumber) throws Exception {
        if (CollectionUtils.isEmpty(tracks)) {
            throw new Exception("tracks is empty");
        }
        if (trackNumber > tracks.size()) {
            throw new Exception("trackNumber is to big");
        }
        String songTitle = tracks.get(trackNumber);
        System.out.println("Playing track " + trackNumber + ": " + songTitle);
	}
}
