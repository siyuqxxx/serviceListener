package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisServerSet;

import java.util.stream.Collectors;

public class LisServerSetBean extends LisServerSet {

    public LisServerSetBean addAll(LisServerSet set) {
        if (set != null) {
            super.getLisServerSet().addAll(set.getLisServerSet().stream().map(LisServerBean::new).filter(e -> !e.isUnresolved())
                    .collect(Collectors.toSet()));
        }
        return this;
    }
}
