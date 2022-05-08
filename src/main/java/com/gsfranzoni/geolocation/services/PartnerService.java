package com.gsfranzoni.geolocation.services;

import com.gsfranzoni.geolocation.dtos.FindNearestPartnerDTO;
import com.gsfranzoni.geolocation.entities.Partner;
import com.gsfranzoni.geolocation.dtos.CreatePartnerDTO;
import com.gsfranzoni.geolocation.mappers.CreatePartnerMapper;
import com.gsfranzoni.geolocation.mappers.FindNearestPartnerMapper;
import com.gsfranzoni.geolocation.repositories.PartnerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CreatePartnerMapper partnerMapper;

    @Autowired
    private FindNearestPartnerMapper findNearestPartnerMapper;

    private GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    public CreatePartnerDTO.Output createPartner(CreatePartnerDTO.Input input) {
        Partner partner = this.partnerMapper.map(input);
        this.partnerRepository.save(partner);
        return this.partnerMapper.map(partner);
    }

    public FindNearestPartnerDTO.Output findNearestPartnerFromLocation(FindNearestPartnerDTO.Input input) {
        Point location = this.geometryFactory.createPoint(new Coordinate(input.latitude(), input.longitude()));
        Partner partner = this.partnerRepository.findByNearestAddress(location)
                .orElseThrow(() -> new RuntimeException("No partner found around this location"));
        return this.findNearestPartnerMapper.map(partner);
    }

    public Partner findById(String id) {
        return this.partnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found"));
    }
}
