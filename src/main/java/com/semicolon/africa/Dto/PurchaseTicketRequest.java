package com.semicolon.africa.Dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseTicketRequest {
    private UUID ticketId;
}
