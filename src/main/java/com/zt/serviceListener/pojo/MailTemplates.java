package com.zt.serviceListener.pojo;

import java.util.HashSet;
import java.util.Set;

public class MailTemplates {
    private Set<MailTemplate> mailSet = new HashSet<>();

    public Set<MailTemplate> getMailSet() {
        return mailSet;
    }

    public MailTemplates setMailSet(Set<MailTemplate> mailSet) {
        this.mailSet = mailSet;
        return this;
    }

    @Override
    public String toString() {
        return "MailTemplates{" +
                "mailSet=" + mailSet +
                '}';
    }
}
