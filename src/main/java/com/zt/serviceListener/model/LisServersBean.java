package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisServers;

import java.util.stream.Collectors;

public class LisServersBean extends LisServers {

    public LisServersBean addAll(LisServers set) {
        if (set != null) {
            super.getLisServers().addAll(set.getLisServers().stream().map(LisServerBean::new).filter(e -> !e.isUnresolved())
                    .collect(Collectors.toSet()));
        }
        return this;
    }
}
