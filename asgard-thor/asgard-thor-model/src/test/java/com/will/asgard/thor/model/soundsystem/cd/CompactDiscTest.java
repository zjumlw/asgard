package com.will.asgard.thor.model.soundsystem.cd;

import com.will.asgard.thor.model.soundsystem.SoundSystemConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class CompactDiscTest {

    @Autowired
    private SgtPeppers cd;

    @Test
    public void test() {
        Assert.notNull(cd);
        cd.play();
    }

}