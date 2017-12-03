package com.zt.serviceListener.model;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.pojo.LisServers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LisServersBean implements IBean<LisServers, LisServersBean> {

    private Set<LisServerBean> servers = new HashSet<>();

    public LisServersBean getResolved() {
        LisServersBean bean = new LisServersBean();
        bean.addAll(servers.stream().filter(s -> !s.isUnresolved()).collect(Collectors.toSet()));
        return bean;
    }

    public LisServersBean getUnresolved() {
        LisServersBean bean = new LisServersBean();
        bean.addAll(servers.stream().filter(LisServerBean::isUnresolved).collect(Collectors.toSet()));
        return bean;
    }

    public Set<String> toHttpUrlSet() {
        return servers.stream().map(s -> Constants.HTTP_HEAD + s.getSocketAddress().toString())
                .collect(Collectors.toSet());
    }

    @Override
    public LisServersBean addAll(LisServers set) {
        if (set != null) {
            servers.addAll(set.getLisServers().stream()
                    .map(LisServerBean::new).collect(Collectors.toSet()));
        }
        return this;
    }

    @Override
    public LisServers toPojo() {
        LisServers lisServers = new LisServers();
        lisServers.setLisServers(servers.stream().map(LisServerBean::toPojo).collect(Collectors.toSet()));
        return lisServers;
    }

    @Override
    public void clean() {
        servers.clear();
    }

    @Override
    public String toString() {
        return "LisServersBean{" +
                "servers=" + servers +
                '}';
    }

    private void addAll(Set<LisServerBean> servers) {
        this.servers.addAll(servers);
    }
}
