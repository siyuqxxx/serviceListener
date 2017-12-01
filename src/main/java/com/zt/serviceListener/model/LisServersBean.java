package com.zt.serviceListener.model;

import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.pojo.LisServers;

import java.util.Set;
import java.util.stream.Collectors;

public class LisServersBean extends LisServers {

    public LisServersBean addResolved(LisServers set) {
        if (set != null) {
            super.getLisServers().addAll(set.getLisServers().stream()
                    .map(LisServerBean::new).filter(e -> !e.isUnresolved())
                    .collect(Collectors.toSet()));
        }
        return this;
    }

    public LisServersBean addUnresolved(LisServers set) {
        super.getLisServers().addAll(set.getLisServers().stream()
                .map(LisServerBean::new).filter(LisServerBean::isUnresolved)
                .collect(Collectors.toSet()));
        return this;
    }

    public Set<String> toHttpUrlSet() {
        return super.getLisServers().stream().map(LisServerBean::new)
                .map(s -> Constants.HTTP_HEAD + s.getSocketAddress().toString())
                .collect(Collectors.toSet());
    }
}
