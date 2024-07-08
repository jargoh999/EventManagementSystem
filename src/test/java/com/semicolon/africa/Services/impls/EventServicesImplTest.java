package com.semicolon.africa.Services.impls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.Dto.AddEventRequest;
import com.semicolon.africa.model.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.test.context.jdbc.Sql;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServicesImplTest {

    @Autowired
    private EventServicesImpl eventServices;

    @Test
    void purchaseTicket() {
    }

    @Test
    void reserveTicket() {
    }
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    void testViewAllEventsForAnOrganizer(){
      var response =eventServices.viewAllEventsFor(100L);
        assertThat(response).hasSize(2);
    }
    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    void testThatOrganizerCanAddAnEvent() {
        AddEventRequest addEventRequest = AddEventRequest.builder()
        .eventDate(LocalDate.parse("2024-07-03"))
        .eventTime(LocalTime.parse("11:30")).eventTitle("title")
                .organizerId(1L)
        .addressId(1L).build();
        var  event =eventServices.addAnEvent(addEventRequest);
        assertThat(event).isNotNull();
    }

}