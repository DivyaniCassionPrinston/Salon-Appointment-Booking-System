package com.salonsystem.salonBookingsystem.payload.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class salonDTO {

    private Long id;

    private String name;

    private List<String> Images;

    private String address;

    private String phonenumber;

    private String email;

    private String city;

    private Long ownerId;

    private LocalTime openTime;

    private LocalTime closeTime;


}
