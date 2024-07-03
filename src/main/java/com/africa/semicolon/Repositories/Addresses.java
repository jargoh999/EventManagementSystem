package com.africa.semicolon.Repositories;

import com.africa.semicolon.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addresses extends JpaRepository<Address,Long> {
}
