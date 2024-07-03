package com.africa.semicolon.Services.impls;

import com.africa.semicolon.Dto.AddDiscountRequest;
import com.africa.semicolon.Dto.TicketResponse;
import com.africa.semicolon.Services.DiscountService;
import com.africa.semicolon.model.Discount;
import com.africa.semicolon.model.Ticket;
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
