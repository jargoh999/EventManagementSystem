package com.semicolon.africa.Repositories;

import com.semicolon.africa.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Guests extends JpaRepository<Guest,Long> {
    @Query("select guest from Guest guest where guest.ticket.event.id=:eventId")
    List<Guest> getGuestByEventId(Long eventId);
}
