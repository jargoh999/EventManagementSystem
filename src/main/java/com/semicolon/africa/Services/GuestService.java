package com.semicolon.africa.Services;
import com.semicolon.africa.Dto.Attendee;
import com.semicolon.africa.Dto.GuestTicketRequest;
import com.semicolon.africa.model.Ticket;

import java.util.List;

public interface GuestService {
    Ticket purchaseTicket(GuestTicketRequest guestTicketRequest);
    Ticket reserveTicket(GuestTicketRequest guestTicketReserveRequest);

}
