package com.sai.repository;

import com.sai.entity.Alert;
import com.sai.entity.HighAlert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Alert create(Alert alert){
        entityManager.persist(alert);
        return alert;
    }

    @Override
    public List<Alert> findAllAlertsByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findByVin", Alert.class);
        query.setParameter("paramVin", vin);
        return query.getResultList();
    }

    @Override
    public List<HighAlert> findHighAlertsCount() {
        List<Object[]> results = entityManager.createNativeQuery(
                "Select a.vin, count(priority) from alert a where a.priority='HIGH' group by a.vin").getResultList();

        return results.stream()
                .map(record -> new HighAlert((String) record[0],((BigInteger) record[1]).intValue() ))
                .collect(Collectors.toList());
    }
}
