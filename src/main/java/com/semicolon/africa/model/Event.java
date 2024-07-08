package com.semicolon.africa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Organizer organizer;
    private String eventTitle;
    private LocalDate eventDate;
    private LocalTime eventTime;
    @ManyToOne
    private Address eventVenue;
}
