package com.sai.service;

import com.sai.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle findByVin(String id);
    Vehicle insertOrUpdate(Vehicle vehicle);
    List<Vehicle> bulkLoad(List<Vehicle> vehicles);
}
