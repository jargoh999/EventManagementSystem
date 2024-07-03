package com.semicolon.africa.Services.impls;

import com.africa.semicolon.Dto.PurchaseTicketResponse;
import com.africa.semicolon.Dto.ReserveTicketResponse;
import com.africa.semicolon.Dto.TicketRequest;
import com.africa.semicolon.Services.TicketService;
import com.africa.semicolon.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServicesImpl implements TicketService {
    @Override
    public List<Ticket> viewAllTicketsFor(Long eventId) {
        return null;
    }

    @Override
    public ReserveTicketResponse reserveTicket(Long ticketId) {
        return null;
    }

    @Override
    public PurchaseTicketResponse purchaseTicket(Long ticketId) {
        return null;
    }

    @Override
    public Ticket createTicket(TicketRequest ticketRequest) {
        return null;
    }


}
