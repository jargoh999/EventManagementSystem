package com.semicolon.africa.Repositories;

import com.africa.semicolon.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tickets extends JpaRepository<Ticket,Long> {
}
