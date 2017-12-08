package com.zt.serviceListener.schedule;

import com.zt.serviceListener.controller.UrlController;
import com.zt.serviceListener.util.UrlDetectUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@DisallowConcurrentExecution
public class ConnectUrlJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(ConnectUrlJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOG.info("==================== start ====================");
        UrlController urlController = new UrlController();

        Set<String> urlSet = urlController.getUrlSet();

        for (String url : urlSet) {
            String result = UrlDetectUtil.callUrl(url);
            LOG.info(result);
        }

        LOG.info("==================== end ====================");
    }
}
