package com.will.asgard.thor.model.soundsystem.player;

import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cdPlayer")
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("CDPlayer is playing");
        cd.play();
    }
}
