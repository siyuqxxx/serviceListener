package com.zt.serviceListener.schedule;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.controller.MailSendController;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

import java.util.Map;

import static com.zt.serviceListener.constants.Constants.ConnectStatus;

public class ConnectListener implements JobListener {
    @Override
    public String getName() {
        return "Connect Listener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        Object result = context.getResult();
        StringBuilder b = new StringBuilder();
        if (result instanceof Map) {
            b.append("follow url has connected error.\n");
            int length = b.length();
            Map<?, ?> map = (Map<?, ?>) result;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getValue() instanceof ConnectStatus) {
                    ConnectStatus status = (ConnectStatus) entry.getValue();
                    if (status == ConnectStatus.ERROR) {
                        b.append(entry.getKey()).append("\n");
                    }
                }
            }
            if (b.length() > length) {
                MailSendController mailSendController = new MailSendController();
                mailSendController.send(b.toString(), Constants.Mail.ERROR_MSG_TEMPLATE);
            }
        }
    }
}
