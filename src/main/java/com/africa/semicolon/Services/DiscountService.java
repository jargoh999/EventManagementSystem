package com.africa.semicolon.Services;

import com.africa.semicolon.Dto.TicketResponse;
import com.africa.semicolon.Dto.AddDiscountRequest;
import com.africa.semicolon.model.Discount;

import java.util.List;

public interface DiscountService {
    List<TicketResponse> viewAllTicketFor(Long id);

    Discount addDiscountToTicket(AddDiscountRequest addDiscountRequest);
}
