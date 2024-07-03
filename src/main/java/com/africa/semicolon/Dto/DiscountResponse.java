package com.africa.semicolon.Dto;

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
    private String percentageDiscount;
    private LocalDate expirationDate;
    private LocalTime expirationTime;
}
