package com.sai.service;

import com.sai.entity.Reading;
import com.sai.entity.Vehicle;
import com.sai.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository repository;

    @Transactional
    public Reading create(Reading reading){
        return repository.create(reading);
    }
}
