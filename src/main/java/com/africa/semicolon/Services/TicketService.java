package com.africa.semicolon.Services;

import com.africa.semicolon.Dto.PurchaseTicketResponse;
import com.africa.semicolon.Dto.ReserveTicketResponse;
import com.africa.semicolon.Dto.TicketRequest;
import com.africa.semicolon.model.Ticket;
import java.util.List;
public interface TicketService {
    List<Ticket> viewAllTicketsFor(Long eventId);
    ReserveTicketResponse reserveTicket(Long ticketId);

    PurchaseTicketResponse purchaseTicket(Long ticketId);

    Ticket createTicket(TicketRequest ticketRequest);
}
