package com.semicolon.africa.Services.impls;

import com.semicolon.africa.Dto.*;
import com.semicolon.africa.Dto.PurchaseTicketResponse;
import com.semicolon.africa.Repositories.Addresses;
import com.semicolon.africa.Repositories.Events;
import com.semicolon.africa.Repositories.Organizers;
import com.semicolon.africa.Services.EventService;
import com.semicolon.africa.model.Event;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServicesImpl implements EventService {

    private final Organizers organizers;
    private final Addresses addresses;
    private final Events events;
    private final ModelMapper modelMapper;


    @Override
    public PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) {return null;}
    @Override
    public TicketResponse reserveTicket(ReserveTicketRequest reserveTicketRequest) {
        return null;
    }
    @Override
    public List<EventResponse> viewAllEventsFor(Long organizerId) {
        return events.getEventByOrganizerId(organizerId)
                .stream().map(event -> modelMapper.map(event,
                        EventResponse.class)).toList();
    }
    @Override
    public Event addAnEvent(AddEventRequest addEventRequest) {
           Event event = Event.builder().organizer(organizers.findOrganizerById(addEventRequest.
           getOrganizerId()).orElseThrow(() -> new RuntimeException(
           "you dont know you are doing"))).eventTitle(addEventRequest.getEventTitle())
           .eventDate(addEventRequest.getEventDate()).eventTime(addEventRequest.getEventTime())
           .eventVenue(addresses.findAddressById(addEventRequest.getAddressId())
           .orElseThrow(()-> new RuntimeException("know what you are doing"))).build();
           return events.save(event);
    }
}
