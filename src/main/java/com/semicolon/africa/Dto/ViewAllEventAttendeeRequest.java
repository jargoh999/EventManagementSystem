package com.semicolon.africa.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.semicolon.africa.model.TicketType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewAllEventAttendeeRequest {
    private Long eventId;
}
