package com.zt.serviceListener.pojo;

import java.util.HashSet;
import java.util.Set;

public class    LisServerSet {
    private Set<LisServer>  lisServerSet = new HashSet<>();

    public Set<LisServer> getLisServerSet() {
        return lisServerSet;
    }

    public void setLisServerSet(Set<LisServer> lisServerSet) {
        this.lisServerSet = lisServerSet;
    }
}
