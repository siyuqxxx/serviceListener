package com.zt.serviceListener.schedule;

import com.zt.serviceListener.TestUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class QuartzManagerTest {
    @Test
    public void getInstance() throws Exception {
        QuartzManager.getInstance().addSchedule(TestUtil.CreateQuartz.schedulerInfoBean_enable());

        QuartzManager.getInstance().addSchedule(TestUtil.CreateQuartz.schedulerInfoBean_disable());

        Thread.sleep(3000);

        QuartzManager.getInstance().removeSchedule(TestUtil.CreateQuartz.schedulerInfoBean_disable());

        Thread.sleep(3000);

        QuartzManager.getInstance().shutdownJobs();

        boolean isStarted = QuartzManager.getInstance().isStarted();

        assertFalse(isStarted);

        QuartzManager.getInstance().clean();
    }
}