package com.africa.semicolon.Dto;

import com.africa.semicolon.model.Address;
import com.africa.semicolon.model.Organizer;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponse {
    private Long id;
    @ManyToOne
    private Organizer organizer;
    private String eventTitle;
    private LocalDate eventDate;
    private LocalTime eventTime;
    @OneToOne
    private Address eventVenue;
}
