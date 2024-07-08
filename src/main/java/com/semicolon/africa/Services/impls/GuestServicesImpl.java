package com.semicolon.africa.Services.impls;

import com.semicolon.africa.Dto.Attendee;
import com.semicolon.africa.Dto.GuestTicketRequest;
import com.semicolon.africa.Repositories.Events;
import com.semicolon.africa.Repositories.Guests;
import com.semicolon.africa.Repositories.Tickets;
import com.semicolon.africa.Services.GuestService;
import com.semicolon.africa.model.Guest;
import com.semicolon.africa.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServicesImpl implements GuestService {
 private final Events events;
 private final Tickets tickets;
 private final TicketServicesImpl ticketServices;
 private final Guests guests;
 private final ModelMapper modelMapper;
    @Override
    public Ticket purchaseTicket(GuestTicketRequest guestTicketRequest) {
           var ticket = tickets.findTicketByEventAndTicketType(guestTicketRequest.getEventId(), guestTicketRequest.getTicketType());
           ticketServices.purchaseTicket(ticket.get().getId());
           ticket = tickets.findTicketById(ticket.get().getId());
           Guest guest = Guest.builder().email(guestTicketRequest.getEmail()).ticket(ticket.get())
           .phoneNumber(guestTicketRequest.getPhoneNumber()).build();
           guests.save(guest);return ticket.get();
    }
    @Override
    public Ticket reserveTicket(GuestTicketRequest guestTicketReserveRequest) {
        var ticket = tickets.findTicketByEventAndTicketType(guestTicketReserveRequest.getEventId(), guestTicketReserveRequest.getTicketType());
        ticketServices.reserveTicket(ticket.get().getId());
        ticket = tickets.findTicketById(ticket.get().getId());
        Guest guest = Guest.builder().email(guestTicketReserveRequest.getEmail()).ticket(ticket.get()).phoneNumber(guestTicketReserveRequest.getPhoneNumber()).build();
        guests.save(guest);return ticket.get();
    }
}
