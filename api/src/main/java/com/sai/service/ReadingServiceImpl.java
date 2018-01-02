package com.sai.service;

import com.sai.entity.Alert;
import com.sai.entity.Reading;
import com.sai.entity.Tire;
import com.sai.entity.Vehicle;
import com.sai.repository.ReadingRepository;
import com.sai.utils.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository repository;

    @Autowired
    private  VehicleService vehicleService;

    @Autowired
    private  AlertService alertService;

    @Transactional
    public Reading create(Reading reading){
        checkRules(reading);
        return repository.create(reading);
    }

    private void checkRules(Reading reading ){
        Vehicle existingVehicle = vehicleService.findByVin(reading.getVin());

        if(existingVehicle != null){

            //Rule: engineRpm > readlineRpm, Priority: HIGH
            if(reading.getEngineRpm() > existingVehicle.getRedlineRpm()){
                alertService.createAlert( new Alert(reading.getVin(), Priority.HIGH.toString(), "The EngineRpm is greater than RedlineRpm"));
            }

            //Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
            if(reading.getFuelVolume() < (0.1* existingVehicle.getMaxFuelVolume())){
                alertService.createAlert(new Alert(reading.getVin(),Priority.MEDIUM.toString(), "The FuelVolume is less than 10% of maxFuelVolume"));
            }
        }

        Tire tires = reading.getTires();
        if( tires!= null){
            //Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
            if(tires.getFrontLeft() < 32 || tires.getFrontRight() < 32 || tires.getRearLeft() < 32 || tires.getRearRight() < 32
                    || tires.getFrontLeft() > 36 || tires.getFrontRight() > 36 || tires.getRearLeft() > 36 || tires.getRearRight() > 36){
                alertService.createAlert(new Alert( reading.getVin(), Priority.LOW.toString(), "The tire pressure is not in the required range"));
            }
        }

        //Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
        if(reading.getEngineCoolantLow() == true|| reading.getCheckEngineLightOn() == true){
            alertService.createAlert(new Alert(reading.getVin(), Priority.LOW.toString(), "The EngineCoolAngent is low or Engine Light is ON"));
        }

    }
}

