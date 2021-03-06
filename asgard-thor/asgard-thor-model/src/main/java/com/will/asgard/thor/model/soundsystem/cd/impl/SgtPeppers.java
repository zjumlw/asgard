package com.will.asgard.thor.model.soundsystem.cd.impl;

import org.springframework.stereotype.Component;

import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;

@Component("sgtPeppers")
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public SgtPeppers() {
        System.out.println("SgtPeppers constructor");
    }

    @Override
    public void play() {
        System.out.println(String.format("Playing %s by %s", title, artist));
    }

    @Override
    public void playTrack(int trackNumber) {

    }
}
