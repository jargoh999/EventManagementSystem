package com.semicolon.africa.Repositories;


import com.semicolon.africa.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Organizers extends JpaRepository<Organizer,Long> {
    Optional<Organizer> findOrganizerByEmailIgnoreCase(String email);

    Optional<Organizer> findOrganizerById(Long id);
}
