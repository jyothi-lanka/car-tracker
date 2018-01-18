package com.sai.repository;

import com.sai.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle findByVin(String vin);
    Vehicle insert(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    List<Vehicle> findAll();
}
