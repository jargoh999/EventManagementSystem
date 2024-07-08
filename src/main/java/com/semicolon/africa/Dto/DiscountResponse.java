package com.semicolon.africa.Dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountResponse {
    private Long id;
    private int percentageDiscount;
    private LocalDate expirationDate;
    private LocalTime expirationTime;
}
