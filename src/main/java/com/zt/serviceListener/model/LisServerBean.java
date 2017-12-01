package com.zt.serviceListener.model;

import com.zt.serviceListener.pojo.LisServer;

import java.net.InetSocketAddress;

public class LisServerBean extends LisServer{
    public LisServerBean() {
    }

    public LisServerBean(LisServer lisServer) {
        super.setIp(lisServer.getIp());
        super.setPort(lisServer.getPort());
        super.setUserName(lisServer.getUserName());
        super.setPassword(lisServer.getPassword());
    }

    /**
     * 判断一组，ip 和 port 是否可以被解析；不考虑不能连接的情况
     * @return true - 不能被解析 | false - 可以正常解析
     */
    public boolean isUnresolved()
    {
        return getSocketAddress().isUnresolved();
    }

    public InetSocketAddress getSocketAddress()
    {
        return new InetSocketAddress(super.getIp(), super.getPort());
    }
}
