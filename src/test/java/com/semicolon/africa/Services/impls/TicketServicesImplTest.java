package com.semicolon.africa.Services.impls;

import com.semicolon.africa.Dto.TicketRequest;
import com.semicolon.africa.model.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TicketServicesImplTest {

    @Autowired
    private TicketServicesImpl ticketServices;
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    public void testToViewAllTicketsFor() {
        var response =ticketServices.viewAllTicketsFor(1L);
        assertThat(response).hasSize(2);
    }

    @Test

    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    public void testToReserveTicket() {
        assertThrows(IllegalArgumentException.class, ()->ticketServices.reserveTicket(UUID.fromString("4cae3788-e52b-49c1-ba5e-b61bb7deda82")));

    }

    @Test


    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    public void testToPurchaseTicket() {
        var response =ticketServices.purchaseTicket(UUID.fromString("4cae3788-e52b-49c1-ba5e-b61bb7deda82"));
        assertThat(response).isNotNull();
    }

    @Test
    public void testToCreateTicket() {
        TicketRequest ticketRequest = TicketRequest.builder()
                .ticketType(TicketType.VIP)
                .price(BigDecimal.valueOf(250))
                .build();
        var response =ticketServices.createTicket(ticketRequest);
        assertThat(response).isNotNull();
    }

}