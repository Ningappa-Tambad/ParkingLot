package com.springAcademy.SpotAssignmentStrategy;

import com.springAcademy.models.Gate;
import com.springAcademy.models.ParkingSpot;
import com.springAcademy.models.VehicleTypes;

public interface SpotAssignmentStrategy {

    ParkingSpot assignSpot(VehicleTypes vehicleType, Gate gate);
}
