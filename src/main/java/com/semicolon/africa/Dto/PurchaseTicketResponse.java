package com.semicolon.africa.Dto;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseTicketResponse {
    private UUID ticketId;
    private String message;
}
