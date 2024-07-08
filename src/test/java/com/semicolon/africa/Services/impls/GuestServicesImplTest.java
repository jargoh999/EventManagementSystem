package com.semicolon.africa.Services.impls;

import com.semicolon.africa.Dto.GuestTicketRequest;
import com.semicolon.africa.model.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GuestServicesImplTest {

    @Autowired
    private GuestServicesImpl guestServices;
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    void testThatGuestCanPurchaseTicket() {
        var request =GuestTicketRequest.builder()
                .ticketType(TicketType.VIP)
                .eventId(1L)
                .email("guest@example.com")
                .phoneNumber("123")
                .build();
        var response= guestServices.purchaseTicket(request);
        assertThat(response).isNotNull();
    }

    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    void testThatGuestCantReserveTicketWhenTimeElapses__throwsException() {
        var request =GuestTicketRequest.builder()
                .ticketType(TicketType.VIP)
                .eventId(1L)
                .email("guest@example.com")
                .phoneNumber("123")
                .build();
        assertThrows(RuntimeException.class,()->guestServices.reserveTicket(request));
    }

}