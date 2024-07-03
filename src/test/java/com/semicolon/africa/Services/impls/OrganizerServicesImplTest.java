package com.semicolon.africa.Services.impls;

import com.semicolon.africa.Dto.OrganizerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrganizerServicesImplTest {

    @Autowired
    private  OrganizerServicesImpl organizerServices;

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
    void addTicketToEvent() {
    }

    @Test
    void addDiscountForTicket() {
    }

    @Test
    void viewAllEventAttendees() {
    }
}