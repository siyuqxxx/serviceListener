package com.zt.serviceListener;

import com.zt.serviceListener.bean.LisInterfaceUrlsBean;
import com.zt.serviceListener.bean.LisServersBean;
import com.zt.serviceListener.constants.Constants;
import com.zt.serviceListener.dao.LisInterfaceUrlsDao;
import com.zt.serviceListener.dao.LisServersDao;
import com.zt.serviceListener.pojo.LisInterfaceUrl;
import com.zt.serviceListener.pojo.LisInterfaceUrls;
import com.zt.serviceListener.pojo.LisServer;
import com.zt.serviceListener.pojo.LisServers;

import java.util.HashSet;
import java.util.Set;

public class TestUtil {
    public static class JsonFile
    {
        public static String LIS_SERVERS = Constants.BASE_DIR + "src\\test\\config\\lis_servers.json";
        public static String LIS_INTERFACE_URL = Constants.BASE_DIR + "src\\test\\config\\lis_interface_urls.json";
    }


    public static LisServersDao createLisServersDao() {
        return new LisServersDao();
    }

    public static class CreateLisServer {
        public static void jsonFile() {
            createLisServersDao().write(JsonFile.LIS_SERVERS, serversBean());
        }

        public static LisServersBean serversBean() {
            LisServers set = new LisServers();
            set.setServerSet(serverSet());

            return new LisServersBean().addAll(set);
        }

        public static Set<LisServer> serverSet() {
            Set<LisServer> lisServers = new HashSet<>();
            lisServers.addAll(serverSet_valid());
            lisServers.addAll(serverSet_invalid());

            return lisServers;
        }

        public static Set<LisServer> serverSet_valid() {
            Set<LisServer> lisServers = new HashSet<>();
            lisServers.add(CreateLisServer.normal_1());
            lisServers.add(CreateLisServer.normal_2());

            return lisServers;
        }

        public static Set<LisServer> serverSet_invalid() {
            Set<LisServer> lisServers = new HashSet<>();
            lisServers.add(CreateLisServer.unresolved());
            lisServers.add(CreateLisServer.disable());

            return lisServers;
        }

        public static LisServer unresolved() {
            LisServer e = new LisServer();
            e.setDescription("unresolved host");
            e.setIp("123456234712");
            e.setPort(8081);
            e.setUserName("root");
            e.setPassword("Test1234_");
            e.setEnable(true);

            return e;
        }

        public static LisServer normal_1() {
            LisServer e = new LisServer();
            e.setIp("123.0.0.1");
            e.setPort(8081);
            e.setDescription("normal 1");

            return e;
        }

        public static LisServer normal_2() {
            LisServer e = new LisServer();
            e.setIp("42.247.27.226");
            e.setPort(8081);
            e.setDescription("normal 2");

            return e;
        }

        public static LisServer disable() {
            LisServer e = new LisServer();
            e.setIp("127.0.0.1");
            e.setPort(8081);
            e.setDescription("disable host");
            e.setEnable(false);

            return e;
        }
    }

    public static class CreateLisInterfaceUrl
    {
        public static LisInterfaceUrlsDao dao()
        {
            return new LisInterfaceUrlsDao();
        }

        public static void jsonFile()
        {
            dao().write(JsonFile.LIS_INTERFACE_URL, urlsbean());
        }

        public static LisInterfaceUrlsBean urlsbean() {
            return new LisInterfaceUrlsBean().addAll(lisInterfaceUrls());
        }

        public static LisInterfaceUrls lisInterfaceUrls() {
            LisInterfaceUrls lisInterfaceUrls = new LisInterfaceUrls();
            lisInterfaceUrls.setUrlSet(urlSet());

            return lisInterfaceUrls;
        }

        public static Set<LisInterfaceUrl> urlSet()
        {
            Set<LisInterfaceUrl> set = new HashSet<>();
            set.add(CreateLisInterfaceUrl.normal_1());
            set.add(CreateLisInterfaceUrl.normal_2());
            set.add(CreateLisInterfaceUrl.disable());

            return set;
        }

        public static LisInterfaceUrl normal_1()
        {
            LisInterfaceUrl u = new LisInterfaceUrl();
            u.setDescription("normal 1");
            u.setLisInterfaceUrl("/test/urt/bookinfo/title/java");

            return u;
        }

        public static LisInterfaceUrl normal_2()
        {
            LisInterfaceUrl u = new LisInterfaceUrl();
            u.setDescription("normal 2");
            u.setLisInterfaceUrl("/test/urt/bookinfo/title/java");

            return u;
        }

        public static LisInterfaceUrl disable()
        {
            LisInterfaceUrl u = new LisInterfaceUrl();
            u.setDescription("disable");
            u.setLisInterfaceUrl("/test/urt/bookinfo/title/java");
            u.setEnable(false);

            return u;
        }
    }


}
