package com.semicolon.africa.Dto;

import com.semicolon.africa.model.TicketType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddDiscountRequest {
    private UUID ticketId;
    private TicketType ticketType;
    private int percentageDiscount;
    private LocalDate expirationDate;
    private LocalTime expirationTime;
}
