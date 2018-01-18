package com.sai.service;

import com.sai.entity.Alert;
import com.sai.entity.HighAlert;

import java.util.List;

public interface AlertService {
    void createAlert(Alert alert);
    List<Alert> findAllAlertsByVin(String vin);
    List<HighAlert> findHighAlertsCount();
}
