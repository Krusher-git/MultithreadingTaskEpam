package com.kozich.multithreading.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class FerryUnloadDaemon extends Thread {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void run() {

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                Ferry ferry = Ferry.getInstance();
                ferry.unloadFerry();
                logger.log(Level.INFO, "Daemon has unload the ferry");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
