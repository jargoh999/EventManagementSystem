package com.africa.semicolon.Dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddDiscountRequest {
    private String discountPercentage;
    private Long ticketId;
}
