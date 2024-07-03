package com.africa.semicolon.Dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseTicketRequest {
    private Long ticketId;
}
