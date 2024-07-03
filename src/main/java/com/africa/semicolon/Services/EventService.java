package com.africa.semicolon.Services;

import com.africa.semicolon.Dto.*;
import com.africa.semicolon.model.Event;
import com.africa.semicolon.model.Ticket;

import java.util.List;

public interface EventService {
    TicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest);

    List<EventResponse> viewAllEventsFor(Long organizerId);

    Event addAnEvent(AddEventRequest addEventRequest);

}
