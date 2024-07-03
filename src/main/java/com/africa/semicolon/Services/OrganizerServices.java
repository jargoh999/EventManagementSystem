package com.africa.semicolon.Services;

import com.africa.semicolon.Dto.*;

import java.util.List;

public interface OrganizerServices {
    OrganizerResponse register(OrganizerRequest organizerRequest);
    EventResponse addTicketTo(TicketRequest addTicketRequest);
    DiscountResponse addDiscountForTicket(AddDiscountRequest addDiscountRequest);
    List<GuestResponse> viewAllEventAttendees(ViewAllEventAttendeeRequest viewAllEventAttendeeRequest);
}
