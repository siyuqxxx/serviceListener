package com.zt.serviceListener;

import com.zt.serviceListener.bean.SchedulerInfoBean;
import com.zt.serviceListener.bean.SchedulerInfosBean;
import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.dao.SchedulerInfosDao;
import com.zt.serviceListener.schedule.QuartzManager;
import com.zt.serviceListener.util.StrUtil;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure(Constants.PropertiesFile.LOG4J);

        if (Objects.nonNull(args) && args.length > 0) {
            String module = StrUtil.toValid(args[0]);
            String command = StrUtil.toValid(args[1]);

            LOG.warn(String.format("module: %s, command: %s.", module, command));

            switch (module) {
                case "schedule":
                    executeScheduleCommand(command);
                    break;
                default:
                    break;
            }
        }
    }

    private static void executeScheduleCommand(String command) {
        switch (command) {
            case "start":
                SchedulerInfosDao dao = new SchedulerInfosDao();
                SchedulerInfosBean read = dao.read(Constants.JsonFile.SCHEDULES);
                for (SchedulerInfoBean bean : read.getSchedulerInfosBean()) {
                    LOG.info("SchedulerInfo: " + bean);
                    QuartzManager.getInstance().addSchedule(bean);
                }
                LOG.info("start Service Listener successful!");
                break;
            case "shutdown":
                QuartzManager.getInstance().shutdownJobs();
                QuartzManager.getInstance().clean();
                LOG.info("shutdown Service Listener successful!");
                break;
            default:
                break;
        }
    }
}
