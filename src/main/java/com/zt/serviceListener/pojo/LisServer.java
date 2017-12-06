package com.zt.serviceListener.pojo;

public class LisServer {
    private String description = "";
    private String ip = "";
    private int port = 0;
    private String userName = "";
    private String password = "";
    private boolean isEnable = true;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof LisServer)) return false;

        LisServer lisServer = (LisServer) o;

        if (port != lisServer.port) return false;
        if (ip != null ? !ip.equals(lisServer.ip) : lisServer.ip != null) return false;
        if (userName != null ? !userName.equals(lisServer.userName) : lisServer.userName != null) return false;
        return password != null ? password.equals(lisServer.password) : lisServer.password == null;
    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + port;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LisServer{" +
                "description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
