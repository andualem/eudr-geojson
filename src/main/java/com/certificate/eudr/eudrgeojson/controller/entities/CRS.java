package com.certificate.eudr.eudrgeojson.controller.entities;

public class CRS {
    private final String type = "WGS84";
    private CRSProperty properties;

    public CRS() {
        this.setProperties(new CRSProperty());
    }

    class CRSProperty {
        private final String name = "urn:ogc:def:crs:OGC:1.3:CRS84";
    }


    public String getType() {
        return type;
    }

    public CRSProperty getProperties() {
        return properties;
    }

    public void setProperties(CRSProperty properties) {
        this.properties = properties;
    }
}
