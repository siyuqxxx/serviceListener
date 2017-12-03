package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisServer;

import java.net.InetSocketAddress;
import java.util.Optional;

public class LisServerBean implements IBean<LisServer, LisServerBean> {

    private LisServer lisServer = new LisServer();

    public LisServerBean() {
    }

    public LisServerBean(LisServer lisServer) {
        addAll(lisServer);
    }

    /**
     * 判断一组，ip 和 port 是否可以被解析；不考虑不能连接的情况
     *
     * @return true - 不能被解析 | false - 可以正常解析
     */
    public boolean isUnresolved() {
        return getSocketAddress().isUnresolved();
    }

    public InetSocketAddress getSocketAddress() {
        return new InetSocketAddress(lisServer.getIp(), lisServer.getPort());
    }

    @Override
    public LisServerBean addAll(LisServer e) {
        this.lisServer = Optional.ofNullable(e).orElse(new LisServer());
        return this;
    }

    @Override
    public LisServer toPojo() {
        return this.lisServer;
    }

    @Override
    public void clean() {
        lisServer = new LisServer();
    }

    @Override
    public String toString() {
        return "LisServerBean{" +
                "lisServer=" + lisServer +
                '}';
    }
}
