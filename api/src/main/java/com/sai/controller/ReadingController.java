package com.sai.controller;

import com.sai.entity.Reading;
import com.sai.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    private ReadingService service;

    @CrossOrigin()
    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading) {
        return service.create(reading);
    }
}

