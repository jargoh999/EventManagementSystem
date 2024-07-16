package com.semicolon.africa.Services.impls;


import com.semicolon.africa.Dto.AddDiscountRequest;
import com.semicolon.africa.Dto.TicketResponse;
import com.semicolon.africa.Services.DiscountService;
import com.semicolon.africa.model.Discount;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServicesImpl implements DiscountService {

    private final TicketServicesImpl ticketServices;
    private final ModelMapper modelMapper;


    @Override
    public List<TicketResponse> viewAllTicketFor(Long id) {
       return ticketServices.viewAllTicketsFor(id).stream().map(event ->modelMapper.map(event, TicketResponse.class)).toList();
    }


}
