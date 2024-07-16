package com.semicolon.africa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Discount {
    @Id
    @GeneratedValue
    private Long id;
    private TicketType ticketType;
    private Integer percentageDiscount;
    private LocalDate expirationDate;
    private LocalTime expirationTime;
}
