package com.sai.repository;

import com.sai.entity.Reading;
import com.sai.entity.Tire;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Reading create(Reading reading){
        Tire tires = reading.getTires();
        entityManager.persist(tires);
        reading.setTires(tires);
        entityManager.persist(reading);
        return reading;
    }
}
