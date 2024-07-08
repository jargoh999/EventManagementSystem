package com.semicolon.africa.Repositories;


import com.semicolon.africa.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Discounts extends JpaRepository<Discount,Long> {

}
