package com.sai.repository;

import com.sai.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Alert create(Alert alert){
        entityManager.persist(alert);
        return alert;
    }
}
