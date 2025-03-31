package com.springAcademy.repositories;

import com.springAcademy.models.Vehicle;

import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long,Vehicle> vehicleMap;
    private Map<String, Vehicle> vehicleMapByRegNo;

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {

        if(vehicleMapByRegNo.containsKey(vehicleNumber))
        {
            return Optional.of(vehicleMapByRegNo.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Optional<Vehicle> findById(Long id) {
        if(vehicleMap.containsKey(id))
        {
            return Optional.of(vehicleMap.get(id));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
        vehicleMapByRegNo.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }


}
