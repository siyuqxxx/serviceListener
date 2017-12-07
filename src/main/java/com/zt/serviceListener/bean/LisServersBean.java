package com.zt.serviceListener.bean;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.pojo.LisServer;
import com.zt.serviceListener.pojo.LisServers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LisServersBean implements IBean<LisServers, LisServersBean> {

    private Set<LisServerBean> serverBeans = new HashSet<>();

    public LisServersBean removeUnresolved() {
        LisServersBean bean = new LisServersBean();
        bean.setServerBeans(serverBeans.stream().filter(s -> !s.isUnresolved()).collect(Collectors.toSet()));
        return bean;
    }

    public LisServersBean removeResolved() {
        LisServersBean bean = new LisServersBean();
        bean.setServerBeans(serverBeans.stream().filter(LisServerBean::isUnresolved).collect(Collectors.toSet()));
        return bean;
    }

    public LisServersBean reomveDisable() {
        LisServersBean bean = new LisServersBean();
        bean.setServerBeans(serverBeans.stream().filter(LisServerBean::isEnable).collect(Collectors.toSet()));
        return bean;
    }

    public void setServerBeans(Set<LisServerBean> serverBeans) {
        this.serverBeans.addAll(serverBeans);
    }

    public Set<String> toHttpUrlSet() {
        return serverBeans.stream().map(s -> Constants.HTTP_HEAD + s.getSocketAddress().toString())
                .collect(Collectors.toSet());
    }

    @Override
    public LisServersBean addAll(LisServers e) {
        if (Objects.nonNull(e)) {
            Set<LisServer> lisServers = e.getServerSet();
            if (Objects.nonNull(lisServers)) {
                serverBeans.addAll(lisServers.stream().map(LisServerBean::new).collect(Collectors.toSet()));
            }
        }
        return this;
    }

    @Override
    public LisServers toPojo() {
        LisServers lisServers = new LisServers();
        lisServers.setServerSet(serverBeans.stream().map(LisServerBean::toPojo).collect(Collectors.toSet()));
        return lisServers;
    }

    @Override
    public void clean() {
        serverBeans.clear();
    }

    @Override
    public String toString() {
        return "LisServersBean{" +
                "serverBeans=" + serverBeans +
                '}';
    }
}
