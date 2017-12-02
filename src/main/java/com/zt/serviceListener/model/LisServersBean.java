package com.zt.serviceListener.model;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.pojo.LisServers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LisServersBean {

    private Set<LisServerBean> servers = new HashSet<LisServerBean>();

    public Set<LisServerBean> getServers() {
        return servers;
    }

    public void setServers(Set<LisServerBean> servers) {
        this.servers = servers;
    }

    public LisServersBean addAll(LisServers set) {
        if (set != null) {
            servers.addAll(set.getLisServers().stream()
                    .map(LisServerBean::new).collect(Collectors.toSet()));
        }
        return this;
    }

    public LisServersBean getResolved() {
        LisServersBean bean = new LisServersBean();
        bean.setServers(servers.stream().filter(s -> !s.isUnresolved()).collect(Collectors.toSet()));
        return bean;
    }

    public LisServersBean getUnresolved() {
        LisServersBean bean = new LisServersBean();
        bean.setServers(servers.stream().filter(LisServerBean::isUnresolved).collect(Collectors.toSet()));
        return bean;
    }

    public Set<String> toHttpUrlSet() {
        return servers.stream().map(s -> Constants.HTTP_HEAD + s.getSocketAddress().toString())
                .collect(Collectors.toSet());
    }

    public LisServers toPojo()
    {
        LisServers lisServers = new LisServers();
        lisServers.setLisServers(servers.stream().map(LisServerBean::getLisServer).collect(Collectors.toSet()));
        return lisServers;
    }

    public void clean()
    {
        servers.clear();
    }
}
