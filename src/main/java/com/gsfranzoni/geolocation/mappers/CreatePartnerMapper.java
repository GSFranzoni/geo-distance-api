package com.gsfranzoni.geolocation.mappers;

import com.gsfranzoni.geolocation.dtos.CreatePartnerDTO;
import com.gsfranzoni.geolocation.entities.Partner;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CreatePartnerMapper {

    public Partner map(CreatePartnerDTO.Input input) {
        Partner partner = new Partner();
        BeanUtils.copyProperties(input, partner);
        return partner;
    }

    public CreatePartnerDTO.Output map(Partner partner) {
        return new CreatePartnerDTO.Output(partner.getId());
    }
}
