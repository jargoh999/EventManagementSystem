package com.africa.semicolon.Repositories;

import com.africa.semicolon.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Events extends JpaRepository<Event,Long> {

}
