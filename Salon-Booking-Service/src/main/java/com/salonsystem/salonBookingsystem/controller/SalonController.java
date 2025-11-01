package com.salonsystem.salonBookingsystem.controller;


import com.salonsystem.salonBookingsystem.mapper.salonMapper;
import com.salonsystem.salonBookingsystem.model.Salon;
import com.salonsystem.salonBookingsystem.payload.dto.salonDTO;
import com.salonsystem.salonBookingsystem.payload.dto.userDTO;
import com.salonsystem.salonBookingsystem.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<salonDTO> createSalon(@RequestBody salonDTO SalonDTO){
        userDTO userDTO= new userDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(SalonDTO, userDTO);
        salonDTO SalonDTO1= salonMapper.mapToDTO(salon);
        return ResponseEntity.ok(SalonDTO1);
    }

    @PatchMapping("/{salonId}")
    public ResponseEntity<salonDTO> updateSalon(@RequestBody salonDTO SalonDTO){
        @PathVariable("SalonId") Long salonId;


        userDTO userDTO= new userDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(SalonDTO, userDTO);
        salonDTO SalonDTO1= salonMapper.mapToDTO(salon);
        return ResponseEntity.ok(SalonDTO1);
    }

}
