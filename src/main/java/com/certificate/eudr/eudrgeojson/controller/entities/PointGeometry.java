package com.certificate.eudr.eudrgeojson.controller.entities;

public class PointGeometry extends Geometry{
    private Double[] coordinates;

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }
}
