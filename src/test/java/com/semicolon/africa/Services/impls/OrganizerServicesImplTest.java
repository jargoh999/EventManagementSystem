package com.semicolon.africa.Services.impls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.Dto.*;
import com.semicolon.africa.Repositories.Tickets;
import com.semicolon.africa.model.Ticket;
import com.semicolon.africa.model.TicketType;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrganizerServicesImplTest {

    @Autowired
    private  OrganizerServicesImpl organizerServices;
    @Autowired
    private TicketServicesImpl ticketServices;
    @Autowired
    private Tickets tickets;

    @Test
    void testThatOrganizerCanRegister() {
        var request = OrganizerRequest.builder()
                .email("test@example.com")
                .password("password")
                .username("username")
                .build();
        var response = organizerServices.register(request);
        assertThat(response).isNotNull();
    }
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    void testToAddTicketToEvent() {
        TicketRequest ticket = TicketRequest.builder().price(TEN)
                .ticketType(TicketType.V_VIP)
                .build();
        var ticke_t =ticketServices.createTicket(ticket);
        AddTicketRequest addTicketRequest = new AddTicketRequest();
        addTicketRequest.setTicketId(ticke_t.getId());
        addTicketRequest.setEventId(1L);
        assertThat(ticke_t.getEvent()).isNull();
        var response =organizerServices.addTicketTo(addTicketRequest);
        ticke_t = tickets.findTicketById(ticke_t.getId()).get();
        assertThat(response.getOrganizer().getId()).isEqualTo(100L);
        assert ticke_t.getEvent() != null;
        assertThat(ticke_t.getEvent().getEventTitle()).isEqualTo("wedding");
    }
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    void testToAddDiscountForTicket() {
        TicketRequest ticket = TicketRequest.builder().price(TEN).ticketType(TicketType.V_VIP).build();
        var ticke_t =ticketServices.createTicket(ticket);
        AddTicketRequest addTicketRequest = new AddTicketRequest();
        addTicketRequest.setTicketId(ticke_t.getId());
        addTicketRequest.setEventId(1L);
        assertThat(ticke_t.getEvent()).isNull();
       organizerServices.addTicketTo(addTicketRequest);
        ticke_t = tickets.findTicketById(ticke_t.getId()).get();
        AddDiscountRequest addDiscountRequest = AddDiscountRequest.builder().percentageDiscount(10).ticketId(ticke_t.getId()).expirationDate(LocalDate.now().plusDays(3L)).expirationTime(LocalTime.NOON).build();
        organizerServices.addDiscountForTicket(addDiscountRequest);
        ticke_t = tickets.findTicketById(ticke_t.getId()).get();
        assertThat(ticke_t.getPrice()).isCloseTo(BigDecimal.valueOf(9), Percentage.withPercentage(100));
    }
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    @Sql(scripts = {"/db/data.Guest.sql"})
    @Test
    void testToViewAllEventAttendees(){
        var response =organizerServices.viewAllEventAttendees(
        ViewAllEventAttendeeRequest.builder().eventId(1L).build());
        assertThat(response).hasSize(2);
    }
}