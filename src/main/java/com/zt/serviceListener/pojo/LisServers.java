package com.zt.serviceListener.pojo;

import java.util.HashSet;
import java.util.Set;

public class LisServers {
    private Set<LisServer> serverSet = new HashSet<>();

    public Set<LisServer> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<LisServer> serverSet) {
        this.serverSet.addAll(serverSet);
    }

    @Override
    public String toString() {
        return "LisServers{" +
                "serverSet=" + serverSet +
                '}';
    }
}
