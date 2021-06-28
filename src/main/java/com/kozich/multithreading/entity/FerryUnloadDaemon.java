package com.kozich.multithreading.entity;

import java.util.concurrent.TimeUnit;

public class FerryUnloadDaemon extends Thread {
    @Override
    public void run() {

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
                Ferry ferry = Ferry.getInstance();
                ferry.unloadFerry();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}