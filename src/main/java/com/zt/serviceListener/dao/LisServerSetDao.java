package com.zt.serviceListener.dao;

import com.zt.serviceListener.model.LisServerSetBean;
import com.zt.serviceListener.pojo.LisServer;
import com.zt.serviceListener.pojo.LisServerSet;
import com.zt.serviceListener.util.JSONUtil;

public class LisServerSetDao {
    public LisServerSetBean read(String path) {
        LisServerSet set = JSONUtil.jsonFile2Obj(path, LisServerSet.class);

        return new LisServerSetBean().addAll(set);
    }

    public void write(String path, LisServerSetBean set) {
        JSONUtil.obj2JsonFile(path, set.getLisServerSet());
    }

    public static void main(String[] args)
    {
        LisServerSetBean set = new LisServerSetBean();
        LisServer e = new LisServer();
        e.setIp("12345678" );
        e.setPort(8081);
        e.setUserName("root");
        e.setPassword("Test1234_");

        LisServer e1 = new LisServer();
        e1.setIp("123.0.0.1");
        e1.setPort(8081);

        LisServer e2 = new LisServer();
        e2.setIp("42.247.27.226");
        e2.setPort(8081);

        set.getLisServerSet().add(e);
        set.getLisServerSet().add(e1);
        set.getLisServerSet().add(e2);

        LisServerSetDao dao = new LisServerSetDao();
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        String path = dir + "\\src\\resource\\lis_server.json";
        System.out.println(path);
        dao.write(path, set);


        LisServerSetBean read = dao.read(path);
        System.out.println(read.getLisServerSet().toString());
    }
}
