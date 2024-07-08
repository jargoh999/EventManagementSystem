package com.semicolon.africa.Repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.semicolon.africa.model.TicketType.VIP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TicketsTest {
    @Autowired
    private Tickets tickets;
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    @Sql(scripts = {"/db/data.ticket.sql"})
    void findTicketByEventAndTicketType() {
        assertThat(tickets.findTicketByEventAndTicketType(1L, VIP)
       .get().getEvent().getEventTitle()).isEqualTo("wedding");
    }
}