package com.springAcademy.controllers;

import com.springAcademy.dtos.IssueTicketRequestDto;
import com.springAcademy.dtos.IssueTicketResponseDto;
import com.springAcademy.dtos.ResponseStatus;
import com.springAcademy.models.Ticket;
import com.springAcademy.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        // Issue ticket logic
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();

        try {
            Ticket ticket=ticketService.issueTicket(issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getVehicleType(),
                    issueTicketRequestDto.getOwnerName());

           responseDto.setTicket(ticket);
           responseDto.setResponseStatus(ResponseStatus.SUCCESS);



        } catch (Exception e) {
            // Log exception

            responseDto.setResponseStatus(ResponseStatus.FAILURE);

        }

        return responseDto;

    }
}
