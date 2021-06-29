package com.kozich.multithreading.entity;

import java.util.concurrent.TimeUnit;

public class FerryUnloadDaemon extends Thread {
    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("dasdasfasf");
                TimeUnit.SECONDS.sleep(1);
                Ferry ferry = Ferry.getInstance();
                ferry.unloadFerry();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
