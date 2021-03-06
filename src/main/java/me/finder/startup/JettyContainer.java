package me.finder.startup;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Robert HG (254963746@qq.com) on 9/1/15.
 */
public class JettyContainer {

    public static void main(String[] args) {
        try {
        	/* String confPath = args[0];

            confPath = confPath.trim();

           Properties conf = new Properties();
            InputStream is = new FileInputStream(new File(confPath + "/conf/lts-admin.cfg"));
            conf.load(is);
            String port = conf.getProperty("port");
            if (port == null || port.trim().equals("")) {
                port = "8081";
            }*/
        	
        	String confPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        	File path = new File(confPath);
        	System.out.println(confPath);
        	
            String port = "8081";
            Server server = new Server(Integer.parseInt(port));
            WebAppContext webapp = new WebAppContext();
            webapp.setWar(path.getParent().toString() + "/finder.spring4-mybatis3.war");
 /*           Map<String, String> initParams = new HashMap<String, String>();
            initParams.put("lts.admin.config.path", confPath + "/conf");
            webapp.setInitParams(initParams);*/
            server.setHandler(webapp);
            server.setStopAtShutdown(true);
            server.start();

            System.out.println("finder.spring4-mybatis3 started. http://" + NetUtils.getLocalHost() + ":" + port + "/index.htm");

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
