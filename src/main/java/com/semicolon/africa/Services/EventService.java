package com.semicolon.africa.Services;



import com.semicolon.africa.Dto.*;
import com.semicolon.africa.model.Event;

import java.util.List;

public interface EventService {
    TicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest);

    PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest);

    List<EventResponse> viewAllEventsFor(Long organizerId);

    Event addAnEvent(AddEventRequest addEventRequest);


}
