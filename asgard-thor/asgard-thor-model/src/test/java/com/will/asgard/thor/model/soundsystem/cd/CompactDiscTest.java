package com.will.asgard.thor.model.soundsystem.cd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.will.asgard.thor.model.hello.ApplicationContextUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDConfig.class)
public class CompactDiscTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void test() {
        Assert.notNull(cd);
        cd.play();
    }

    @Test
    public void testApplicationContextUtil() {
        ApplicationContext context = ApplicationContextUtil.getApplicationContext();
        System.out.println(context);

        CompactDisc cd = (CompactDisc) context.getBean("lonelyHeartsClubBand");
        cd.play();
    }
}