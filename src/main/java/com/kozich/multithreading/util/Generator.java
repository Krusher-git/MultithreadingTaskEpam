package com.kozich.multithreading.util;

import java.util.Random;

public class Generator {
    private static Random generator = new Random();
    private static final int DEFAULT_LIGHT_CAR_WEIGHT = 500;
    private static final int DEFAULT_HEAVY_CAR_WEIGHT = 1000;
    private static final int DEFAULT_LIGHT_CAR_SQUARE = 10;
    private static final int DEFAULT_HEAVY_CAR_SQUARE = 30;
    private static final int DEFAULT_FERRY_CAPACITY = 2000;
    private static final int DEFAULT_FERRY_SQUARE = 150;

    public static int generateVehicleWeight(boolean isLightCar) {
        return isLightCar ? DEFAULT_LIGHT_CAR_WEIGHT + generator.nextInt(500) :
                DEFAULT_HEAVY_CAR_WEIGHT + generator.nextInt(1500);
    }

    public static int generateVehicleSquare(boolean isLightCar) {
        return isLightCar ? DEFAULT_LIGHT_CAR_SQUARE + generator.nextInt(19) :
                DEFAULT_HEAVY_CAR_SQUARE + generator.nextInt(30);
    }

    public static int generateFerryCapacity() {
        return DEFAULT_FERRY_CAPACITY;
    }
    public static int generateFerrySquare() {
        return DEFAULT_FERRY_SQUARE;
    }
}
