package com.gsfranzoni.geolocation.controller;

import com.gsfranzoni.geolocation.dtos.CreatePartnerDTO;
import com.gsfranzoni.geolocation.dtos.FindNearestPartnerDTO;
import com.gsfranzoni.geolocation.entities.Partner;
import com.gsfranzoni.geolocation.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity<CreatePartnerDTO.Output> createPartner(@RequestBody CreatePartnerDTO.Input createPartnerDTO) {
        try {
            CreatePartnerDTO.Output partner = this.partnerService.createPartner(createPartnerDTO);
            return ResponseEntity.ok(partner);
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable String id) {
        try {
            Partner partner = this.partnerService.findById(id);
            return ResponseEntity.ok(partner);
        }
        catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nearest/{latitude}/{longitude}")
    public ResponseEntity<FindNearestPartnerDTO.Output> getNearestPartnerFromLocation(
            @PathVariable FindNearestPartnerDTO.Input input) {
        try {
            FindNearestPartnerDTO.Output partner = this.partnerService.findNearestPartnerFromLocation(input);
            return ResponseEntity.ok(partner);
        }
        catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
