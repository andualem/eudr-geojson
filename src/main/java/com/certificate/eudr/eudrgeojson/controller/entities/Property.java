package com.certificate.eudr.eudrgeojson.controller.entities;

public class Property {

    private String ProducerName;
    private final String  ProducerCountry = "ET";
    private String ProductionPlace;
    private Double Area;

    //TRACT related properties

    private String PlotID;
    private String NodeID;


    public String getProducerName() {
        return ProducerName;
    }

    public void setProducerName(String producerName) {
        ProducerName = producerName;
    }


    public String getProductionPlace() {
        return ProductionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        ProductionPlace = productionPlace;
    }

    public Double getArea() {
        return Area;
    }

    public void setArea(Double area) {
        Area = area;
    }

    public String getPlotID() {
        return PlotID;
    }

    public void setPlotID(String plotID) {
        PlotID = plotID;
    }

    public String getNodeID() {
        return NodeID;
    }

    public void setNodeID(String nodeID) {
        NodeID = nodeID;
    }
}
