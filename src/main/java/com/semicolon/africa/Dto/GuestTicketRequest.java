package com.semicolon.africa.Dto;
import com.semicolon.africa.model.Ticket;
import com.semicolon.africa.model.TicketType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestTicketRequest {
    private Long id;
    private String email;
    private String phoneNumber;
    private Long eventId;
    private TicketType ticketType;
}
