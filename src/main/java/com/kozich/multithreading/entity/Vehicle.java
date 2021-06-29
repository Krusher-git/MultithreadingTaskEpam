package com.kozich.multithreading.entity;

import com.kozich.multithreading.util.Generator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Vehicle extends Thread {
    private static final Logger logger = LogManager.getLogger();
    private boolean isLightCar;
    private int weight;
    private int square;

    public Vehicle(boolean isLightCar) {
        this.isLightCar = isLightCar;
        weight = Generator.generateVehicleWeight(isLightCar);
        square = Generator.generateVehicleSquare(isLightCar);
    }


    @Override
    public void run() {
        Ferry ferry = Ferry.getInstance();
        logger.log(Level.INFO, "Try to load ferry by " + this.toString());
        boolean loaded = false;
        while (!loaded) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                logger.log(Level.FATAL, "InterruptedException with " + this.toString());
                Thread.currentThread().interrupt();
            }
            loaded = ferry.addVehicle(this);
        }
        logger.log(Level.INFO, this.toString() + " is on a board");
    }

    public int getWeight() {
        return weight;
    }

    public int getSquare() {
        return square;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vehicle: " + Thread.currentThread().getName());
        builder.append(" is light car: ").append(isLightCar);
        return builder.toString();
    }
}
