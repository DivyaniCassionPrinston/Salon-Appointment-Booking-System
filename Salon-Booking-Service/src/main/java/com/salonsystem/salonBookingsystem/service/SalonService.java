package com.salonsystem.salonBookingsystem.service;

import com.salonsystem.salonBookingsystem.model.Salon;
import com.salonsystem.salonBookingsystem.payload.dto.salonDTO;
import com.salonsystem.salonBookingsystem.payload.dto.userDTO;

import java.util.List;

public interface SalonService {

    Salon createSalon(salonDTO salon, userDTO user);

    Salon updateSalon(salonDTO salon, userDTO user, Long salonId) throws Exception;

    List<Salon> getallsalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByownerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);


}
