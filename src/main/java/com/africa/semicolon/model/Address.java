package com.africa.semicolon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String state;
    private String city;
    private String streetName;
    private String streetNumber;
}
