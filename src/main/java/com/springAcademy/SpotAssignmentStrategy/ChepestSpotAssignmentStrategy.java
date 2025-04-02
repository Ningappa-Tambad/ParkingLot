package com.springAcademy.SpotAssignmentStrategy;

import com.springAcademy.models.Gate;
import com.springAcademy.models.ParkingSpot;
import com.springAcademy.models.VehicleTypes;

public class ChepestSpotAssignmentStrategy implements SpotAssignmentStrategy {

    public void assignSpot() {
        System.out.println("Cheapest spot assignment strategy");
    }

    @Override
    public ParkingSpot assignSpot(VehicleTypes vehicleType, Gate gate) {
        return null;
    }
}
