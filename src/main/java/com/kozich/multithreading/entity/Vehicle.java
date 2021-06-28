package com.kozich.multithreading.entity;

import com.kozich.multithreading.util.Generator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        logger.log(Level.INFO, "Try to load ferry by " + Thread.currentThread().getName());
        ferry.addVehicle(this);

    }

    public int getWeight() {
        return weight;
    }

    public int getSquare() {
        return square;
    }
}
