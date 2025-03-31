package com.springAcademy.services;

import com.springAcademy.Exception.GateIdNotFoundException;
import com.springAcademy.models.Gate;
import com.springAcademy.models.Ticket;
import com.springAcademy.models.Vehicle;
import com.springAcademy.models.VehicleTypes;
import com.springAcademy.repositories.GateRepository;
import com.springAcademy.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {



    private GateRepository gateRepository;

    private VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Ticket issueTicket(Long gateId, String VehicleNumber,
                              VehicleTypes VehicleType, String OwnerName)
    {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        //issue ticket

       Optional<Gate> optionalGate =gateRepository.findById(gateId);

       if(optionalGate.isEmpty())
       {
           throw new GateIdNotFoundException("Gate with id" + gateId + "Does not exist");
       }
       Gate gate = optionalGate.get();
       ticket.setGeneratedAt(gate);

        Optional<Vehicle> optinalVehicle = vehicleRepository.findByVehicleNumber(VehicleNumber);


        Vehicle savedVehicle = null;
        if(optinalVehicle.isEmpty())
        {
           //Create new vehicle in the data base
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(VehicleNumber);
            vehicle.setVehicleType(VehicleType);
            vehicle.setOwnerName(OwnerName);
            savedVehicle= vehicleRepository.save(vehicle);
        }
        else {
            savedVehicle = optinalVehicle.get();
        }

        ticket.setVehicle(savedVehicle);

        ticket.setTicketNumber("Ticket number");

   return null;
    }
}
