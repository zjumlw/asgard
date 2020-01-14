package com.will.asgard.thor.model.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class EncoreableTest {

    @Autowired
    private Performance performance;

    @Test
    public void testAudience() throws Exception {
        performance.perform();
    }

    @Test
    public void testEncoreable() throws Exception {
        Assert.isTrue(performance instanceof Encoreable);
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
    }

}