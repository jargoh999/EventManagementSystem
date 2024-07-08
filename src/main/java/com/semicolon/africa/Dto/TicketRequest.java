package com.semicolon.africa.Dto;

import com.semicolon.africa.model.Discount;
import com.semicolon.africa.model.TicketStatus;
import com.semicolon.africa.model.TicketType;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketRequest {
    private Long eventId;
    private TicketType ticketType;
    private BigDecimal price;
    private Long discountId;
    private TicketStatus ticketStatus;
}
