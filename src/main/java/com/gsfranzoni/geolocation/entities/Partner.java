package com.gsfranzoni.geolocation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    @Column(unique = true)
    private String document;
    @Column(columnDefinition = "MultiPolygon")
    private MultiPolygon coverageArea;
    @Column(columnDefinition = "Point")
    private Point address;
}
