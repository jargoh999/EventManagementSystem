package com.semicolon.africa.Services;


import com.semicolon.africa.Dto.AddDiscountRequest;
import com.semicolon.africa.Dto.TicketResponse;
import com.semicolon.africa.model.Discount;

import java.util.List;

public interface DiscountService {
    List<TicketResponse> viewAllTicketFor(Long id);

    Discount addDiscountToTicket(AddDiscountRequest addDiscountRequest);
}
