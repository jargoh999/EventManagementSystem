package com.semicolon.africa.Services;

import com.semicolon.africa.Dto.PurchaseTicketResponse;
import com.semicolon.africa.Dto.ReserveTicketResponse;
import com.semicolon.africa.Dto.TicketRequest;
import com.semicolon.africa.model.*;

import java.util.List;
public interface TicketService {
    List<Ticket> viewAllTicketsFor(Long eventId);
    ReserveTicketResponse reserveTicket(Long ticketId);

    PurchaseTicketResponse purchaseTicket(Long ticketId);

    Ticket createTicket(TicketRequest ticketRequest);
}
