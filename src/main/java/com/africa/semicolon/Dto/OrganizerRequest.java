package com.africa.semicolon.Dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizerRequest {
    private String username;
    private String email;
    private String password;
}
