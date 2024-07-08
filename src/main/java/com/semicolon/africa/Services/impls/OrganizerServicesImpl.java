package com.semicolon.africa.Services.impls;


import com.semicolon.africa.Dto.EventResponse;
import com.semicolon.africa.Dto.OrganizerRequest;
import com.semicolon.africa.Dto.OrganizerResponse;
import com.semicolon.africa.Dto.*;
import com.semicolon.africa.Repositories.*;
import com.semicolon.africa.Services.OrganizerServices;
import com.semicolon.africa.model.Discount;
import com.semicolon.africa.model.Organizer;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrganizerServicesImpl implements OrganizerServices {
    private final Organizers organizers;
    private final ModelMapper modelMapper;
    private final Tickets tickets;
    private final Events events;
    private final Discounts discounts;
    private final Guests guests;

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
    public EventResponse addTicketTo(AddTicketRequest addTicketRequest) {

        var ticket =tickets.findTicketById(addTicketRequest.getTicketId())
        .orElseThrow(() -> new RuntimeException("ticket not found"));
        ticket.setEvent(events.findById(addTicketRequest.getEventId()).orElseThrow(
        () -> new RuntimeException("event not found")));
        tickets.save(ticket);
        return modelMapper.map(ticket.getEvent(),EventResponse.class);
    }

    @Override
    public DiscountResponse addDiscountForTicket(AddDiscountRequest addDiscountRequest) {
           var ticket =tickets.findTicketById(addDiscountRequest.getTicketId()).orElseThrow(() -> new RuntimeException("ticket not found"));
           if(!isValidPercentage(addDiscountRequest.getPercentageDiscount())) throw new RuntimeException("Invalid percentage-discount");
        BigDecimal percentageDiscount =calculateDiscountOnTicketPrice(ticket.getPrice(),addDiscountRequest.getPercentageDiscount());
        Discount discount = Discount.builder().expirationDate(addDiscountRequest.getExpirationDate()).ticketType(addDiscountRequest.getTicketType()).expirationTime(addDiscountRequest.getExpirationTime()).percentageDiscount(addDiscountRequest.getPercentageDiscount()).build();
        var savedDiscount=discounts.save(discount);ticket.setDiscount(discount);
        ticket.setPrice(ticket.getPrice().subtract(percentageDiscount));tickets.save(ticket);
        return modelMapper.map(savedDiscount, DiscountResponse.class);
    }

    @Override
    public List<GuestResponse> viewAllEventAttendees(ViewAllEventAttendeeRequest viewAllEventAttendeeRequest) {
               return guests.getGuestByEventId(viewAllEventAttendeeRequest.getEventId()).stream().map(guest -> modelMapper.map(guest,GuestResponse.class)).toList();
    }


    private boolean isValidPercentage(int  percentage) {
        return percentage >= 0 && percentage <= 100;
    }

    private BigDecimal calculateDiscountOnTicketPrice(BigDecimal price , int percentage) {
        return price.multiply(BigDecimal.valueOf(percentage).divide(BigDecimal.valueOf(100L)));
    }


}
