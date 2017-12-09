package com.zt.serviceListener.bean;

import com.zt.serviceListener.pojo.MailTemplate;
import com.zt.serviceListener.pojo.MailTemplates;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MailTemplatesBean implements IBean<MailTemplates, MailTemplatesBean> {
    private Set<MailTemplateBean> mailBeans = new HashSet<>();

    public MailTemplateBean find(int id) {
        Map<Integer, MailTemplateBean> map = mailBeans.stream().collect(Collectors.toMap(MailTemplateBean::getId, m -> m));
        return map.containsKey(id) ? map.get(id) : new MailTemplateBean();
    }

    public MailTemplatesBean removeDisable() {
        MailTemplatesBean bean = new MailTemplatesBean();
        bean.setMailBeans(mailBeans.stream().filter(MailTemplateBean::isEnable).collect(Collectors.toSet()));
        return bean;
    }

    public Set<MailTemplateBean> getMailBeans() {
        return mailBeans;
    }

    public MailTemplatesBean setMailBeans(Set<MailTemplateBean> mailBeans) {
        this.mailBeans = mailBeans;
        return this;
    }

    @Override
    public MailTemplatesBean addAll(MailTemplates e) {
        if (Objects.nonNull(e)) {
            Set<MailTemplate> lisServers = e.getMailSet();
            if (Objects.nonNull(lisServers)) {
                mailBeans.addAll(lisServers.stream().map(MailTemplateBean::new).collect(Collectors.toSet()));
            }
        }
        return this;
    }

    @Override
    public MailTemplates toPojo() {
        MailTemplates mailTemplates = new MailTemplates();
        mailTemplates.setMailSet(mailBeans.stream().map(MailTemplateBean::toPojo).collect(Collectors.toSet()));
        return mailTemplates;
    }

    @Override
    public void clean() {
        mailBeans.clear();
    }

    @Override
    public String toString() {
        return "MailTemplatesBean{" +
                "mailBeans=" + mailBeans +
                '}';
    }
}
