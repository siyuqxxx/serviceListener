package com.zt.serviceListener.pojo;

public class MailTemplate {
    private int id = 0;
    private String subject = "";
    private String from = "";
    private String replyTo = "";
    private String carbonCopy = "";
    private String content = "";
    private String contentType = "";
    private boolean isEnable = true;

    public int getId() {
        return id;
    }

    public MailTemplate setId(int id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MailTemplate setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public MailTemplate setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public MailTemplate setReplyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public String getCarbonCopy() {
        return carbonCopy;
    }

    public MailTemplate setCarbonCopy(String carbonCopy) {
        this.carbonCopy = carbonCopy;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MailTemplate setContent(String content) {
        this.content = content;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public MailTemplate setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public MailTemplate setEnable(boolean enable) {
        isEnable = enable;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailTemplate mailTemplate = (MailTemplate) o;

        return id == mailTemplate.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "MailTemplate{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", from='" + from + '\'' +
                ", replyTo='" + replyTo + '\'' +
                ", carbonCopy='" + carbonCopy + '\'' +
                '}';
    }
}
