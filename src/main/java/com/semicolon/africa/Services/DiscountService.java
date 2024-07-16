package com.semicolon.africa.Services;
import com.semicolon.africa.Dto.TicketResponse;
import java.util.List;
public interface DiscountService {
    List<TicketResponse> viewAllTicketFor(Long id);
}
