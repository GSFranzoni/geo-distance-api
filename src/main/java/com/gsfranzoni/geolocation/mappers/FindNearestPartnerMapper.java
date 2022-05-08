package com.gsfranzoni.geolocation.mappers;

import com.gsfranzoni.geolocation.dtos.FindNearestPartnerDTO;
import com.gsfranzoni.geolocation.entities.Partner;
import org.springframework.stereotype.Component;

@Component
public class FindNearestPartnerMapper {
   public FindNearestPartnerDTO.Output map(Partner partner) {
        return new FindNearestPartnerDTO.Output(
                partner.getId(),
                partner.getTradingName(),
                partner.getOwnerName(),
                partner.getDocument()
        );
    }
}
