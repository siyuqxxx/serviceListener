package com.zt.serviceListener.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerTest {
    public static void main(String[] args) {

        //通过schedulerFactory获取一个调度器
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
//      通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

//       创建jobDetail实例，绑定Job实现类
//       指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "jgroup1").build();


//       定义调度触发规则

//      使用simpleTrigger规则
//        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
//                        .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8))
//                        .startNow().build();
//      使用cornTrigger规则  每天10点42分
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 42 10 * * ? *"))
                    .startNow().build();

//       把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);

//       启动调度
            scheduler.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
