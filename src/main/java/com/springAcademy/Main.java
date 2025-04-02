package com.springAcademy;

import com.springAcademy.controllers.TicketController;
import com.springAcademy.dtos.IssueTicketRequestDto;
import com.springAcademy.dtos.IssueTicketResponseDto;
import com.springAcademy.models.VehicleTypes;
import com.springAcademy.repositories.GateRepository;
import com.springAcademy.repositories.ParkingLotRepository;
import com.springAcademy.repositories.TicketRepository;
import com.springAcademy.repositories.VehicleRepository;
import com.springAcademy.services.TicketService;

public class Main {
    public static void main(String[] args) {

        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketRepository ticketRepository = new TicketRepository();


        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setVehicleNumber("KA-01-HH-8055");
        issueTicketRequestDto.setOwnerName("Avyaan");
        issueTicketRequestDto.setVehicleType(VehicleTypes.LARGE);

        IssueTicketResponseDto issueTicketResponseDto = ticketController.issueTicket(issueTicketRequestDto);

        // Display the output
        System.out.println("Response Status: " + issueTicketResponseDto.getResponseStatus());
        if (issueTicketResponseDto.getTicket() != null) {
            System.out.println("Ticket Details: " + issueTicketResponseDto.getTicket());
        } else {
            System.out.println("No ticket issued.");
        }


    }
}