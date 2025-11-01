package com.salonsystem.salonBookingsystem.mapper;

import com.salonsystem.salonBookingsystem.model.Salon;
import com.salonsystem.salonBookingsystem.payload.dto.salonDTO;

public class salonMapper {

    public static salonDTO mapToDTO(Salon salon){
        salonDTO SalonDTO =  new salonDTO();
        SalonDTO.setId(salon.getId());

        SalonDTO.setName(salon.getName());
        SalonDTO.setAddress(salon.getAddress());
        SalonDTO.setEmail(salon.getEmail());
        SalonDTO.setCity(salon.getCity());
        SalonDTO.setImages(salon.getImages());
        SalonDTO.setOwnerId(salon.getOwnerId());
        SalonDTO.setOpenTime(salon.getOpenTime());
        SalonDTO.setCloseTime(salon.getCloseTime());
        SalonDTO.setPhonenumber(salon.getPhonenumber());

        return SalonDTO;
    }
}
