package com.semicolon.africa.Dto;

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
