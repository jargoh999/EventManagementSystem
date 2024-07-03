package com.africa.semicolon.Dto;

import com.africa.semicolon.model.Discount;
import com.africa.semicolon.model.Event;
import com.africa.semicolon.model.TicketStatus;
import com.africa.semicolon.model.TicketType;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponse {
    private Long eventId;
    private TicketType table;
    private BigDecimal price;
    private Discount discount;
    private TicketStatus ticketStatus;
}
