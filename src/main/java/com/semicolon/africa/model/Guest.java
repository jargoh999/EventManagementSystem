package com.semicolon.africa.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Guest {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String phoneNumber;
    @ManyToOne
    @JoinTable(name = "guest's ticket")
    private Ticket ticket;
}
