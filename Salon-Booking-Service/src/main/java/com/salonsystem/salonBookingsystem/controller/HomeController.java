package com.salonsystem.salonBookingsystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String HomecontrollerHandler(){
        return "Salon microservice for salon booking system";
    }
}
