package com.semicolon.africa.Dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@RequiredArgsConstructor
public class Attendee {
    private UUID id;
    private String email;
    private String phoneNumber;
    private  Long ticketId;
}
