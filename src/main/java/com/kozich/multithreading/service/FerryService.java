package com.kozich.multithreading.service;

import com.kozich.multithreading.entity.Vehicle;

import java.util.List;

public interface FerryService {
    void vehicleDelivery(List<Vehicle> vehicles);
}
