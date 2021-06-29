package com.kozich.multithreading.entity;

import com.kozich.multithreading.util.Generator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {
    private static final AtomicInteger INITIAL_SQUARE = new AtomicInteger(Generator.generateFerrySquare());
    private static final AtomicInteger INITIAL_WEIGHT = new AtomicInteger(Generator.generateFerryCapacity());
    private AtomicInteger square;
    private AtomicInteger weight;
    private List<Vehicle> vehicles;
    private Lock lock = new ReentrantLock();
    private static final Logger logger = LogManager.getLogger();
    private static final Ferry instance = new Ferry();

    private Ferry() {
        square = INITIAL_SQUARE;
        weight = INITIAL_WEIGHT;
        vehicles = new LinkedList<>();
    }

    public static Ferry getInstance() {
        return instance;
    }

    public boolean addVehicle(Vehicle vehicle) {
        lock.lock();
        logger.log(Level.INFO, vehicle.toString() + " is trying to get on a board");
        try {
            if (square.get() - vehicle.getSquare() < 0 || weight.get() - vehicle.getWeight() < 0) {
                logger.log(Level.INFO, "Not enough space on a board for this " + vehicle.toString());
                return false;
            }
            vehicles.add(vehicle);
            int tempSquare = square.get() - vehicle.getSquare();
            int tempWeight = weight.get() - vehicle.getWeight();
            square.set(tempSquare);
            weight.set(tempWeight);


        } catch (Exception e) {
            logger.log(Level.WARN, "Something goes wrong with " + Thread.currentThread().getName(), e);
        } finally {
            lock.unlock();

        }
        return true;
    }


    public void unloadFerry() {
        try {
            lock.lock();
            if (vehicles.isEmpty()) {
                logger.log(Level.WARN, "There are no vehicles on a board");
                return;
            }
            logger.log(Level.INFO, "Current vehicles are going to be delivered " + vehicles.toString());
            vehicles.clear();
            square.set(INITIAL_SQUARE.get());
            weight.set(INITIAL_WEIGHT.get());
            logger.log(Level.INFO, "Ferry has unloaded");
        } finally {
            lock.unlock();
        }
    }
}
