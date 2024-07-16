package com.semicolon.africa.Repositories;


import com.semicolon.africa.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Events extends JpaRepository<Event,Long> {
   @Query("SELECT event FROM Event event WHERE event.organizer.id=:organizerId")
   List<Event> getEventByOrganizerId(Long organizerId);
}
