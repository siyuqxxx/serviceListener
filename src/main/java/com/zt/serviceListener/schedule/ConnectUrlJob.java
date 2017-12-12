package com.zt.serviceListener.schedule;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.controller.UrlController;
import com.zt.serviceListener.util.UrlDetectUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@DisallowConcurrentExecution
public class ConnectUrlJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(ConnectUrlJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOG.error("==================== start ====================");

        Map<String, Constants.ConnectStatus> result = new HashMap<>();

        Set<String> urlSet = new UrlController().getUrlSet();
        for (String url : urlSet) {
            try {
                LOG.info("call url: " + url);
                String response = UrlDetectUtil.callUrl(url);
                result.put(url, Constants.ConnectStatus.SUCCESS);
                LOG.info(response);
            } catch (IOException e) {
                result.put(url, Constants.ConnectStatus.ERROR);
                LOG.error("service connect error. url: " + url, e);
            }
        }

        context.setResult(result);

        LOG.error("==================== end ====================");
    }
}
