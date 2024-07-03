package com.semicolon.africa.Dto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseTicketResponse {
    private Long ticketId;
    private String message;
}
