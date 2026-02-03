package com.certificate.eudr.eudrgeojson.controller.entities;

import java.util.List;

public class FeatureCollection {

    private final String type = "FeatureCollection";
    private String name;
    private List<Feature> features;

    private CRS crs;

    public FeatureCollection() {
        this.setCrs(new CRS());
    }


    public String getType() {
        return type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CRS getCrs() {
        return crs;
    }

    public void setCrs(CRS crs) {
        this.crs = crs;
    }
}
