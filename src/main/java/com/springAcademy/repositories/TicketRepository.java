package com.springAcademy.repositories;

import com.springAcademy.models.Ticket;

import java.util.HashMap;

public class TicketRepository {

    private HashMap<Long, Ticket> ticketMap;

    private Long id;

    public TicketRepository() {
        ticketMap = new HashMap<>();
        id = 0L;
    }

    public Ticket save(Ticket ticket) {
        ticket.setId(id);
        ticketMap.put(id, ticket);
        id++;
        return ticket;
    }
}
