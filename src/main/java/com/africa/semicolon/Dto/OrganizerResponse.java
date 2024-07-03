package com.africa.semicolon.Dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizerResponse {
    private String username;
    private String email;
    private String password;
}
