package com.salonsystem.salonBookingsystem.service.impl;

import com.salonsystem.salonBookingsystem.model.Salon;
import com.salonsystem.salonBookingsystem.payload.dto.salonDTO;
import com.salonsystem.salonBookingsystem.payload.dto.userDTO;
import com.salonsystem.salonBookingsystem.repository.SalonRepository;
import com.salonsystem.salonBookingsystem.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(salonDTO req, userDTO user) {
        Salon salon = new Salon();
        salon.setName(req.getName());
        salon.setAddress(req.getAddress());
        salon.setEmail(req.getEmail());
        salon.setCity(req.getCity());
        salon.setImages(req.getImages());
        salon.setOwnerId(user.getId());
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());
        salon.setPhonenumber(req.getPhonenumber());

        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(salonDTO salon, userDTO user, Long salonId) throws Exception {

        Salon exsitingsalon = salonRepository.findById(salonId).orElse(null);
        if (exsitingsalon != null && salon.getOwnerId().equals(user.getId())){
            exsitingsalon.setName(salon.getName());
            exsitingsalon.setAddress(salon.getAddress());
            exsitingsalon.setEmail(salon.getEmail());
            exsitingsalon.setCity(salon.getCity());
            exsitingsalon.setImages(salon.getImages());
            exsitingsalon.setOwnerId(user.getId());
            exsitingsalon.setOpenTime(salon.getOpenTime());
            exsitingsalon.setCloseTime(salon.getCloseTime());
            exsitingsalon.setPhonenumber(salon.getPhonenumber());
        }

        throw new Exception("salon not exist");
    }

    @Override
    public List<Salon> getallsalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon == null){
            throw new Exception("salon not exist");
        }
        return salon;
    }

    @Override
    public Salon getSalonByownerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
