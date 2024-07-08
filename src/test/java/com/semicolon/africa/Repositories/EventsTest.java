package com.semicolon.africa.Repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventsTest {

    @Autowired
    private Events events;

    @Test
    @Sql(scripts = {"/db/data.organizer.sql"})
    @Sql(scripts = {"/db/data.address.sql"})
    @Sql(scripts = {"/db/data.Event.sql"})
    void getEventByOrganizerId() {
       var event = events.getEventByOrganizerId(100L);
       assertThat(event).hasSize(2);
    }
}