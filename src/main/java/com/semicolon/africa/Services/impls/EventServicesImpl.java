package com.semicolon.africa.Services.impls;

import com.semicolon.africa.Dto.*;
import com.semicolon.africa.Dto.PurchaseTicketResponse;
import com.semicolon.africa.Services.EventService;
import com.semicolon.africa.model.Event;
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
