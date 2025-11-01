package com.salonsystem.salonBookingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data //provides set of constructors and getter setter methods also
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false) //mandatory field
    private String name;

    @ElementCollection //to keep the seperate table for this images
    private List<String> Images;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private LocalTime openTime;

    @Column(nullable = false)
    private LocalTime closeTime;



}
