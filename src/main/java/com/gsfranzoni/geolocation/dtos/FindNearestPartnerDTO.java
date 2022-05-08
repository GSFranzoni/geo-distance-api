package com.gsfranzoni.geolocation.dtos;

public class FindNearestPartnerDTO {
    public static record Input(
            double latitude,
            double longitude
    ) {}
    public static record Output(
            String id,
            String tradingName,
            String ownerName,
            String document
    ) {}
}
