package com.sai.repository;

import com.sai.entity.Alert;
import com.sai.entity.HighAlert;

import java.util.List;

public interface AlertRepository {
    Alert create(Alert alert);
    List<Alert> findAllAlertsByVin(String vin);
    List<HighAlert> findHighAlertsCount();
}
