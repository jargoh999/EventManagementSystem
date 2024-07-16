package com.semicolon.africa.Dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReserveTicketRequest {
    private UUID ticketId;
}

