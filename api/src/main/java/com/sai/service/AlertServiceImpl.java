package com.sai.service;

import com.sai.entity.Alert;
import com.sai.entity.HighAlert;
import com.sai.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Transactional
    public void createAlert(Alert alert){
        alertRepository.create(alert);
    }

    @Override
    public List<Alert> findAllAlertsByVin(String vin) {
        return alertRepository.findAllAlertsByVin(vin);
    }

    @Override
    public List<HighAlert> findHighAlertsCount() {
        return alertRepository.findHighAlertsCount();
    }

}
