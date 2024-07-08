package com.semicolon.africa.Dto;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestResponse {
    private Long id;
    private String email;
    private String phoneNumber;
    private UUID ticketId;
}
