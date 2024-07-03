package com.semicolon.africa.Repositories;

import com.africa.semicolon.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Guests extends JpaRepository<Guest,Long> {
}
