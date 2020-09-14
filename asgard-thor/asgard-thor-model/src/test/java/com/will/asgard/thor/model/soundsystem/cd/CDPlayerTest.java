package com.will.asgard.thor.model.soundsystem.cd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.asgard.thor.model.soundsystem.player.CDPlayerConfig;
import com.will.asgard.thor.model.soundsystem.player.MediaPlayer;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-14 17:49
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void test() {
        mediaPlayer.play();
    }
}
