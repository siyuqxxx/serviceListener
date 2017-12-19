package com.zt.serviceListener.schedule;

import com.zt.serviceListener.bean.SchedulerInfoBean;
import com.zt.serviceListener.pojo.Quartz.JobDescription;
import com.zt.serviceListener.pojo.Quartz.TriggerDescription;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class QuartzManager {
    private static final Logger LOG = LoggerFactory.getLogger(QuartzManager.class);

    private static QuartzManager mgr = null;
    private SchedulerFactory factory = null;

    private QuartzManager() {
        getFactory();
    }

    public static QuartzManager getInstance() {
        if (Objects.isNull(mgr)) {
            mgr = new QuartzManager();
        }
        return mgr;
    }

    private SchedulerFactory getFactory() {
        if (Objects.isNull(factory)) {
            factory = new StdSchedulerFactory();
        }
        return factory;
    }

    /**
     * 添加一个定时任务，可以包括至少一个触发
     */
    public void addSchedule(SchedulerInfoBean s) {
        if (Objects.isNull(s) || !s.hasTriggers()) {
            return;
        }

        try {
            Scheduler scheduler = factory.getScheduler();
            // 任务名，任务组，任务执行类
            JobDescription jobDescription = s.toPojo().getJob();
            JobDetail job = JobBuilder.newJob(jobDescription.getJobClazz())
                    .withIdentity(jobDescription.getName(), jobDescription.getGroup())
                    .storeDurably().build();

            KeyMatcher<JobKey> keyMatcher = KeyMatcher.keyEquals(job.getKey());
            scheduler.getListenerManager().addJobListener(new ConnectListener(), keyMatcher);

            scheduler.addJob(job, true);

            for (TriggerDescription t : s.toPojo().getTriggers()) {
                Trigger workDayTrigger = TriggerBuilder.newTrigger()
                        .withIdentity(t.getName(), t.getGroup())
                        .withSchedule(CronScheduleBuilder.cronSchedule(t.getCron()))
                        .startNow().forJob(job).build();

                scheduler.scheduleJob(workDayTrigger);
            }

            // scheduler 如果已经启动，则马上启动新增的计划
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            LOG.error("add job error", e);
        }
    }

    /**
     * 移除一个任务
     */
    public void removeSchedule(SchedulerInfoBean s) {
        if (Objects.isNull(s) || !s.hasTriggers()) {
            return;
        }

        try {
            Scheduler scheduler = factory.getScheduler();

            for (TriggerDescription t : s.toPojo().getTriggers()) {
                TriggerKey triggerKey = TriggerKey.triggerKey(t.getName(), t.getGroup());

                scheduler.pauseTrigger(triggerKey);// 停止触发器
                scheduler.unscheduleJob(triggerKey);// 移除触发器
            }

            JobDescription job = s.toPojo().getJob();
            scheduler.deleteJob(JobKey.jobKey(job.getName(), job.getGroup()));// 删除任务
        } catch (SchedulerException e) {
            LOG.error("remove job error", e);
        }
    }

    public boolean isShutdown() {
        try {
            return factory.getScheduler().isShutdown();
        } catch (SchedulerException e) {
            LOG.error("get Quartz manager is shutdown status error", e);
            return false;
        }
    }

    public boolean isStarted() {
        try {
            return factory.getScheduler().isStarted();
        } catch (SchedulerException e) {
            LOG.error("get Quartz manager is started status error", e);
            return false;
        }
    }

    /**
     * 启动所有定时任务
     */
    public void startJobs() {
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            LOG.error("start Quartz manager error", e);
        }
    }

    /**
     * 关闭所有定时任务
     */
    public void shutdownJobs() {
        try {
            Scheduler scheduler = factory.getScheduler();
            if (scheduler.isStarted()) {
                scheduler.shutdown(true);
            }
        } catch (SchedulerException e) {
            LOG.error("shutdown Quartz manager error", e);
        }
    }

    public void clean() {
        if (Objects.nonNull(factory)) {
            shutdownJobs();
            factory = null;
        }

        if (Objects.nonNull(mgr)) {
            mgr = null;
        }
    }
}
