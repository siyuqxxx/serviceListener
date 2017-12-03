package com.zt.serviceListener.pojo;

import java.util.HashSet;
import java.util.Set;

public class LisServers {
    private Set<LisServer> lisServers = new HashSet<>();

    public Set<LisServer> getLisServers() {
        return lisServers;
    }

    public void setLisServers(Set<LisServer> lisServers) {
        this.lisServers.addAll(lisServers);
    }

    @Override
    public String toString() {
        return "LisServers{" +
                "lisServers=" + lisServers +
                '}';
    }
}
