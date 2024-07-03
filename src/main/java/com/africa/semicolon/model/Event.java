package com.africa.semicolon.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Organizer organizer;
    private String eventTitle;
    private LocalDate eventDate;
    private LocalTime eventTime;
    @OneToOne
    private Address eventVenue;
}
