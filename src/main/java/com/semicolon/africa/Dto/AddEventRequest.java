package com.semicolon.africa.Dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AddEventRequest {
    private Long organizerId;
    private String eventTitle;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Long addressId;
}
