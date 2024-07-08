package com.semicolon.africa.Services.impls;


import com.semicolon.africa.Dto.PurchaseTicketResponse;
import com.semicolon.africa.Dto.ReserveTicketResponse;
import com.semicolon.africa.Dto.TicketRequest;
import com.semicolon.africa.Repositories.Tickets;
import com.semicolon.africa.Services.TicketService;
import com.semicolon.africa.model.Ticket;
import com.semicolon.africa.model.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.semicolon.africa.model.TicketStatus.PURCHASED;
import static com.semicolon.africa.model.TicketStatus.RESERVED;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class TicketServicesImpl implements TicketService {
    private final Tickets tickets;
    @Override
    public List<Ticket> viewAllTicketsFor(Long eventId) {
         var listOfTicket = tickets.findTicketByEventId(eventId);
         if(listOfTicket.isEmpty())throw new RuntimeException("No tickets found for event");
         return listOfTicket;
    }

    @Override
    public ReserveTicketResponse reserveTicket(UUID ticketId) {
        var ticket =tickets.findTicketById(ticketId).orElseThrow(
        ()-> new RuntimeException("Could not find ticket"));
        if(!now().plusWeeks(1).isBefore(ticket.getEvent().getEventDate().atTime(ticket.getEvent().getEventTime()))) throw new IllegalArgumentException("you no go fit reserve ticket boss time don go");
        return ReserveTicketResponse.builder().ticketId(tickets.save(ticket).getId()).message("successfully purchased").build();
    }

    @Override
    public PurchaseTicketResponse purchaseTicket(UUID ticketId) {
           var ticket =tickets.findTicketById(ticketId).orElseThrow(()-> new RuntimeException("Could not find"));
           if(!now().plusDays(4L).isBefore(ticket.getEvent().getEventDate().atTime(ticket.getEvent().getEventTime()))) throw new IllegalArgumentException("you no go fit purchase ticket boss time don go");
           return PurchaseTicketResponse.builder().ticketId(tickets.save(ticket).getId()).message("successfully purchased").build();
    }

    @Override
    public Ticket createTicket(TicketRequest ticketRequest) {
        Ticket ticket = Ticket.builder()
                .ticketType(ticketRequest.getTicketType())
                .price(ticketRequest.getPrice())
                .build();
        return tickets.save(ticket);
    }
}
