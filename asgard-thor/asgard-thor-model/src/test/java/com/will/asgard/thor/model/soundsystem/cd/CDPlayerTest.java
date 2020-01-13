package com.will.asgard.thor.model.soundsystem.cd;

import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;
import com.will.asgard.thor.model.soundsystem.player.CDPlayerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void test() {
        Assert.notNull(cd);
        cd.play();
    }

}