package com.zt.serviceListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class App
{
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws IOException {

//        PropertyConfigurator.configure(Constants.PropertiesFile.LOG4J);
//
//        if (args.length > 0) {
//            URL url = new URL(args[0]);
//            try (InputStream inputStream = url.openStream()) {
//                Scanner s = new Scanner(inputStream);
//                while (s.hasNext()) {
//                    System.out.println(s.next());
//                }
//            }
//        } else {
//            System.out.println("empty input.");
//        }
//        LOG.info("test");

//        InetSocketAddress address = new InetSocketAddress("42.247.27.226", 8081);
        InetSocketAddress address = new InetSocketAddress("0.2.3.4", 8081);
        boolean unresolved = address.isUnresolved();

        final Socket socket = new Socket();
        try {
            socket.connect(address);
        } catch (IOException e) {
            e.printStackTrace();
        }// 连接远程主机
//        Thread reader = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    byte[] buffer = new byte[512];
//                    InputStream stream = socket.getInputStream();
//                    socket.getInputStream().read(buffer);
//                } catch (Exception ex) {
//
//                }
//            }
//        };
//        reader.start();
//
//        try (InputStream stream = socket.getInputStream())
//        {
//            Scanner s = new Scanner(stream);
//            while (s.hasNext())
//            {
//                System.out.println(s.next());
//            }
//        }

        System.out.println(address);



        System.out.println(unresolved);

    }
}
