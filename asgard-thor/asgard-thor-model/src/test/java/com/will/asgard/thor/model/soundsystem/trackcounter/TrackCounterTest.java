package com.will.asgard.thor.model.soundsystem.trackcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {
    @Autowired
    private CompactDisc cd;
    @Autowired
    private TrackCounter counter;

    @Test
    public void test() throws Exception {
        cd.playTrack(0);
        cd.playTrack(1);
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(4);
        System.out.println(counter.getPlayCount(0));
        System.out.println(counter.getPlayCount(1));
        System.out.println(counter.getPlayCount(2));
        System.out.println(counter.getPlayCount(3));
        System.out.println(counter.getPlayCount(4));

    }
}