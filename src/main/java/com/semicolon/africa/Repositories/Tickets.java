package com.semicolon.africa.Repositories;
import com.semicolon.africa.model.Ticket;
import com.semicolon.africa.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Tickets extends JpaRepository<Ticket, UUID> {
    Optional<Ticket> findTicketById(UUID uuid);
    @Query("SELECT ticket FROM Ticket ticket WHERE ticket.ticketType=:ticketType AND ticket.event.id=:eventId")
    Optional<Ticket> findTicketByEventAndTicketType(Long eventId, TicketType ticketType);
    @Query("SELECT ticket FROM Ticket ticket WHERE ticket.event.id=:eventId")
    List<Ticket> findTicketByEventId(Long eventId);
}
