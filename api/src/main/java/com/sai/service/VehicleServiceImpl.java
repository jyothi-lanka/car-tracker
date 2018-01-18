package com.sai.service;

import com.sai.entity.Vehicle;
import com.sai.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public Vehicle findByVin(String id) {
        return repository.findByVin(id);
    }

    @Transactional
    public Vehicle insertOrUpdate(Vehicle vehicle){
        Vehicle existing= findByVin(vehicle.getVin());
        if (existing == null) {
            return repository.insert(vehicle);
        }
        return repository.update(vehicle);
    }
    @Transactional
    public List<Vehicle> bulkLoad(List<Vehicle> vehicles){
        List<Vehicle> createdVehicles = new ArrayList<>();
        vehicles.forEach(vehicle ->createdVehicles.add(insertOrUpdate(vehicle)));
        return createdVehicles;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

}
