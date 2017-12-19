package com.zt.serviceListener.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class TestJob_2 implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String name = context.getJobDetail().getKey().getName();
        System.out.println("execute test schedule job " + name + ". " + new Date());
    }
}
