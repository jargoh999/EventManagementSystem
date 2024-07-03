package com.semicolon.africa.Services.impls;


import com.semicolon.africa.Dto.AddDiscountRequest;
import com.semicolon.africa.Dto.TicketResponse;
import com.semicolon.africa.Services.DiscountService;
import com.semicolon.africa.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServicesImpl implements DiscountService {


    @Override
    public List<TicketResponse> viewAllTicketFor(Long id) {
        return null;
    }

    @Override
    public Discount addDiscountToTicket(AddDiscountRequest addDiscountRequest) {
        return null;
    }
}
