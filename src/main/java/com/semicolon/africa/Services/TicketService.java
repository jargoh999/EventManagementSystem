package com.semicolon.africa.Services;

import com.semicolon.africa.Dto.PurchaseTicketResponse;
import com.semicolon.africa.Dto.ReserveTicketResponse;
import com.semicolon.africa.Dto.TicketRequest;
import com.semicolon.africa.model.*;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    List<Ticket> viewAllTicketsFor(Long eventId);
    ReserveTicketResponse reserveTicket(UUID ticketId);

    PurchaseTicketResponse purchaseTicket(UUID ticketId);

    Ticket createTicket(TicketRequest ticketRequest);
}
