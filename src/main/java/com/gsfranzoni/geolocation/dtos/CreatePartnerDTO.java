package com.gsfranzoni.geolocation.dtos;

import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;

public class CreatePartnerDTO {
    public static record Input(
            String id,
            String tradingName,
            String ownerName,
            String document,
            MultiPolygon coverageArea,
            Point address
    ) {}
    public static record Output(
            String id
    ) {}
}
