package com.sai.service;

import com.sai.entity.Alert;
import com.sai.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Transactional
    public void createAlert(Alert alert){
        alertRepository.create(alert);
    }
}
