package com.semicolon.africa.Repositories;


import com.semicolon.africa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Addresses extends JpaRepository<Address,Long> {
    Optional<Address> findAddressById(Long addressId);
}
