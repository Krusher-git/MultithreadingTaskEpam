package com.kozich.multithreading.entity;

import com.kozich.multithreading.util.Generator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private Queue<Vehicle> vehicles;
    private Lock lock = new ReentrantLock();
    private static final Logger logger = LogManager.getLogger();
    private static final Ferry instance = new Ferry();

    private Ferry() {
        square = INITIAL_SQUARE;
        weight = INITIAL_WEIGHT;
        vehicles = new PriorityQueue<>();
    }

    public static Ferry getInstance() {
        return instance;
    }

    public void addVehicle(Vehicle vehicle) {
        lock.lock();
        System.out.println("gadfaass");
        try {
            if (square.get() - vehicle.getSquare() < 0 || weight.get() - vehicle.getWeight() < 0) {
                logger.log(Level.INFO, "Not enough space on a board for this " + Thread.currentThread().getName() + " vehicle");
                return;
            }
            vehicles.add(vehicle);
            int tempSquare = square.get() - vehicle.getSquare();
            int tempWeight = weight.get() - vehicle.getWeight();
            square.set(tempSquare);
            weight.set(tempWeight);

//            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Exception e) {
            logger.log(Level.WARN, "Something goes wrong with " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public void unloadFerry() {
        try {
            lock.lock();
            vehicles.clear();
            square.set(INITIAL_SQUARE.get());
            weight.set(INITIAL_WEIGHT.get());
            logger.log(Level.INFO, "Ferry has unloaded");
        } finally {
            lock.unlock();
        }
    }
}
