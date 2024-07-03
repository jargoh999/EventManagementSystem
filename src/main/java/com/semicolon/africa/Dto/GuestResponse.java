package com.semicolon.africa.Dto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Long ticketId;
    private Long eventId;
}
