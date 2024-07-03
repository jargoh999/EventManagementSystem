package com.semicolon.africa.Services.impls;


import com.semicolon.africa.Dto.EventResponse;
import com.semicolon.africa.Dto.OrganizerRequest;
import com.semicolon.africa.Dto.OrganizerResponse;
import com.semicolon.africa.Dto.*;
import com.semicolon.africa.Repositories.Organizers;
import com.semicolon.africa.Services.OrganizerServices;
import com.semicolon.africa.model.Organizer;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrganizerServicesImpl implements OrganizerServices {
    private final Organizers organizers;
    private final ModelMapper modelMapper;

    @Override
    public OrganizerResponse register(OrganizerRequest organizerRequest) {
        if(organizers.findOrganizerByEmailIgnoreCase(organizerRequest.getEmail()).isPresent())
            throw new RuntimeException("you are already registered");
        Organizer organizer = Organizer.builder()
                .email(organizerRequest.getEmail()).password(organizerRequest.getPassword())
                .username(organizerRequest.getUsername()).build();
       return modelMapper.map(organizers.save(organizer),OrganizerResponse.class);
    }

    @Override
    public EventResponse addTicketTo(TicketRequest addTicketRequest) {
        return null;
    }

    @Override
    public DiscountResponse addDiscountForTicket(AddDiscountRequest addDiscountRequest) {
        return null;
    }

    @Override
    public List<GuestResponse> viewAllEventAttendees(ViewAllEventAttendeeRequest viewAllEventAttendeeRequest) {
        return null;
    }


}
