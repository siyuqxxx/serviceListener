package com.zt.serviceListener;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.schedule.ConnectListener;
import com.zt.serviceListener.schedule.ConnectUrlJob;
import org.apache.log4j.PropertyConfigurator;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure(Constants.PropertiesFile.LOG4J);

        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerfactory.getScheduler();

            JobDetail job = JobBuilder.newJob(ConnectUrlJob.class).withIdentity("job1", "jgroup1")
                    .storeDurably().build();

            Trigger workDayTrigger = TriggerBuilder.newTrigger().withIdentity("workday", "triggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/30 8-22 ? * MON-FRI"))
                    .startNow().forJob(job).build();

            Trigger weekendTrigger = TriggerBuilder.newTrigger().withIdentity("weekend", "triggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 15 8-22 ? * SAT-SUN"))
                    .startNow().forJob(job).build();

            KeyMatcher<JobKey> keyMatcher = KeyMatcher.keyEquals(job.getKey());
            scheduler.getListenerManager().addJobListener(new ConnectListener(), keyMatcher);

            scheduler.addJob(job, true);
            scheduler.scheduleJob(workDayTrigger);
            scheduler.scheduleJob(weekendTrigger);

            scheduler.start();
        } catch (SchedulerException e) {
            LOG.error("Scheduler runtime error.", e);
        }
    }
}
