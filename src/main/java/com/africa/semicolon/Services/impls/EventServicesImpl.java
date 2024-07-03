package com.africa.semicolon.Services.impls;

import com.africa.semicolon.Dto.*;
import com.africa.semicolon.Services.EventService;
import com.africa.semicolon.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServicesImpl implements EventService {


    @Override
    public PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) {
        return null;
    }

    @Override
    public TicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest) {
        return null;
    }

    @Override
    public List<EventResponse> viewAllEventsFor(Long organizerId) {
        return null;
    }

    @Override
    public Event addAnEvent(AddEventRequest addEventRequest) {
        return null;
    }
}
