package com.zt.serviceListener.dao;

import com.zt.serviceListener.TestUtil;
import com.zt.serviceListener.bean.SchedulerInfosBean;
import com.zt.serviceListener.pojo.Quartz.SchedulerInfo;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SchedulerInfosDaoTest {
    @Test
    public void schedulerInfosDaoTest() throws Exception {
// set up
        TestUtil.CreateQuartz.jsonFile();

        // test
        SchedulerInfosDao dao = new SchedulerInfosDao();
        SchedulerInfosBean read = dao.read(TestUtil.JsonFile.SCHEDULES);

        System.out.println(read);

        Set<SchedulerInfo> testSchedulerInfos = TestUtil.CreateQuartz.schedulerInfoSet();
        Set<? extends SchedulerInfo> schedulerInfoSet = read.toPojo().getSchedulerInfoSet();
        assertEquals(testSchedulerInfos.size() - 1, schedulerInfoSet.size());

        for (SchedulerInfo m : schedulerInfoSet) {
            assertTrue(testSchedulerInfos.contains(m));
        }
    }

}