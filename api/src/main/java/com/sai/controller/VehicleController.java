package com.sai.controller;

import com.sai.entity.Vehicle;
import com.sai.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> bulkLoad(@RequestBody List<Vehicle>  vehicles) {
        return service.bulkLoad(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles() {
        return service.findAll();
    }
}