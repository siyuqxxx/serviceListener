package com.zt.serviceListener.controller;

import com.zt.serviceListener.bean.MailTemplateBean;
import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.dao.MailTemplatesDao;
import com.zt.serviceListener.util.MailUtil;

public class MailSendController {
    public void send(String content, int mailTemplateId) {
        MailTemplateBean bean = new MailTemplatesDao().read(Constants.JsonFile.MAIL).find(mailTemplateId);
        bean.setContent(content);

        MailUtil.send(bean);
    }
}
