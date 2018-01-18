package com.sai.controller;


import com.sai.entity.Alert;
import com.sai.entity.HighAlert;
import com.sai.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService service;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public List<Alert> getAllAlertsByVin(@PathVariable("id") String vin) {
        return service.findAllAlertsByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/high")
    public List<HighAlert> getHighAlertsCount() {
        return service.findHighAlertsCount();
    }
}