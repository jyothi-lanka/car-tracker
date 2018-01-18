package com.sai.repository;

import com.sai.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Vehicle findByVin(String vin){
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle insert(Vehicle vehicle){
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle){
        return entityManager.merge(vehicle);
    }

    @Override
    public List<Vehicle> findAll(){
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",Vehicle.class);

        return query.getResultList();
    }
}