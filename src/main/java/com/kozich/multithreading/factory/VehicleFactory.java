package com.kozich.multithreading.factory;

import com.kozich.multithreading.entity.Vehicle;
import com.kozich.multithreading.exception.ThreadingException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class VehicleFactory {
    private static final Logger logger = LogManager.getLogger();

    public List<Vehicle> generateVehicles(List<Integer> parameters) throws ThreadingException {
        if (parameters.size() != 2) {
            logger.log(Level.ERROR, "Exception with the amount of incoming parameters");
            throw new ThreadingException("Exception with the amount of incoming parameters");
        }
        int lightCarsAmount = parameters.get(0);
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < lightCarsAmount; i++) {
            vehicles.add(new Vehicle(true));
        }
        int heavyCarsAmount = parameters.get(1);
        for (int i = 0; i < heavyCarsAmount; i++) {
            vehicles.add(new Vehicle(false));
        }
        return vehicles;
    }
}
