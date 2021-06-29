package com.kozich.multithreading.service.impl;

import com.kozich.multithreading.entity.FerryUnloadDaemon;
import com.kozich.multithreading.entity.Vehicle;
import com.kozich.multithreading.exception.ThreadingException;
import com.kozich.multithreading.parser.ValueParser;
import com.kozich.multithreading.reader.CustomFileReader;
import com.kozich.multithreading.service.FerryService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FerryServiceImpl implements FerryService {
    private static Logger logger = LogManager.getLogger();

    public void vehicleDelivery(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            logger.log(Level.INFO, vehicle.toString() + " is working");
        }
    }
}
