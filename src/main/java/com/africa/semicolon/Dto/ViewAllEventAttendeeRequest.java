package com.africa.semicolon.Dto;

import com.africa.semicolon.model.TicketType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewAllEventAttendeeRequest {
    private Long eventId;
    private TicketType ticketType;
}
