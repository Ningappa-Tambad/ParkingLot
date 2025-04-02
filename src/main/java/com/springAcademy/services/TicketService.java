package com.springAcademy.services;

import com.springAcademy.Exception.GateIdNotFoundException;
import com.springAcademy.SpotAssignmentStrategy.SpotAssignmentStrategy;
import com.springAcademy.factories.SpotAssignmentStrategyFactroy;
import com.springAcademy.models.*;
import com.springAcademy.repositories.GateRepository;
import com.springAcademy.repositories.ParkingLotRepository;
import com.springAcademy.repositories.TicketRepository;
import com.springAcademy.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {



    private GateRepository gateRepository;

    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;

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

        Optional<ParkingLot> optionalParkingLot =parkingLotRepository.findByGateId(gateId);


        if(optionalParkingLot.isEmpty())
        {
          throw new RuntimeException("Parking lot not found for gate id" + gateId);
        }

        ParkingLot parkingLot = optionalParkingLot.get();

        SpotAssignmentStrategy spotAssignmentStrategyType = SpotAssignmentStrategyFactroy.getSpotAssignmentStrategy(parkingLot.getSpotAssignmentStrategyType());


        ParkingSpot parkingSpot= spotAssignmentStrategyType.assignSpot(VehicleType,gate);


        if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.NOT_AVAILABLE))
        {
            throw new RuntimeException("parking spot not available");
        }

        ticket.setParkingSpot(parkingSpot);
        ticketRepository.save(ticket);

        return ticket;

    }
}
