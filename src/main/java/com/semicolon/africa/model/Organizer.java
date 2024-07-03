package com.semicolon.africa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Organizer {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
}


