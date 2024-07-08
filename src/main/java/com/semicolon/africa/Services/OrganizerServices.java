package com.semicolon.africa.Services;



import com.semicolon.africa.Dto.*;

import java.util.List;

public interface OrganizerServices {
    OrganizerResponse register(OrganizerRequest organizerRequest);
    EventResponse addTicketTo(AddTicketRequest addTicketRequest);
    DiscountResponse addDiscountForTicket(AddDiscountRequest addDiscountRequest);
    List<GuestResponse> viewAllEventAttendees(ViewAllEventAttendeeRequest viewAllEventAttendeeRequest);
}
