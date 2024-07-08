package com.semicolon.africa.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
@RequiredArgsConstructor
public class AddTicketRequest {
    private UUID ticketId;
    private Long EventId;
}
