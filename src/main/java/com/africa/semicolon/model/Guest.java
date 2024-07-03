package com.africa.semicolon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@RequiredArgsConstructor
public class Guest {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    @OneToOne
    private Ticket ticket;

}
