package com.springAcademy.SpotAssignmentStrategy;

import com.springAcademy.models.Gate;
import com.springAcademy.models.ParkingSpot;
import com.springAcademy.models.VehicleTypes;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    public int assignSpot() {
        return (int) (Math.random() * 100);
    }

    @Override
    public ParkingSpot assignSpot(VehicleTypes vehicleType, Gate gate) {
        return null;
    }
}
