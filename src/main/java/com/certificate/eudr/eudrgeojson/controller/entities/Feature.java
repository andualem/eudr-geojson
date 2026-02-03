package com.certificate.eudr.eudrgeojson.controller.entities;

public class Feature {

    private final String type = "Feature";
    private Property properties;
    private Geometry geometry;

    public String getType() {
        return type;
    }

    public Property getProperties() {
        return properties;
    }

    public void setProperties(Property properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
