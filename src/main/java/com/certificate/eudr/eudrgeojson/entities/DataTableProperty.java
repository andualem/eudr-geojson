package com.certificate.eudr.eudrgeojson.entities;

import javafx.beans.property.SimpleStringProperty;

public class DataTableProperty {

    private SimpleStringProperty  year;
    private SimpleStringProperty farmerId;
    private SimpleStringProperty  farmerName;
    private SimpleStringProperty  farmId;
    private SimpleStringProperty  farmName;
    private SimpleStringProperty  farmGroup;
    private SimpleStringProperty  farmYield;
    private SimpleStringProperty  farmSize;
    private SimpleStringProperty  gpsLatitude;
    private SimpleStringProperty  gpsLongitude;

    //TRACT related attributes
    private SimpleStringProperty  plotId;
    private SimpleStringProperty  nodeId;

    private SimpleStringProperty  deforestationDetected;
    private SimpleStringProperty  deforestationRemark;


    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getFarmerId() {
        return farmerId.get();
    }

    public SimpleStringProperty farmerIdProperty() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId.set(farmerId);
    }

    public String getFarmerName() {
        return farmerName.get();
    }

    public SimpleStringProperty farmerNameProperty() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName.set(farmerName);
    }

    public String getFarmId() {
        return farmId.get();
    }

    public SimpleStringProperty farmIdProperty() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId.set(farmId);
    }

    public String getFarmName() {
        return farmName.get();
    }

    public SimpleStringProperty farmNameProperty() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName.set(farmName);
    }

    public String getFarmGroup() {
        return farmGroup.get();
    }

    public SimpleStringProperty farmGroupProperty() {
        return farmGroup;
    }

    public void setFarmGroup(String farmGroup) {
        this.farmGroup.set(farmGroup);
    }

    public String getFarmYield() {
        return farmYield.get();
    }

    public SimpleStringProperty farmYieldProperty() {
        return farmYield;
    }

    public void setFarmYield(String farmYield) {
        this.farmYield.set(farmYield);
    }

    public String getFarmSize() {
        return farmSize.get();
    }

    public SimpleStringProperty farmSizeProperty() {
        return farmSize;
    }

    public void setFarmSize(String farmSize) {
        this.farmSize.set(farmSize);
    }

    public String getGpsLatitude() {
        return gpsLatitude.get();
    }

    public SimpleStringProperty gpsLatitudeProperty() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude.set(gpsLatitude);
    }

    public String getGpsLongitude() {
        return gpsLongitude.get();
    }

    public SimpleStringProperty gpsLongitudeProperty() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude.set(gpsLongitude);
    }

    public String getPlotId() {
        return plotId.get();
    }

    public SimpleStringProperty plotIdProperty() {
        return plotId;
    }

    public void setPlotId(String plotId) {
        this.plotId.set(plotId);
    }

    public String getNodeId() {
        return nodeId.get();
    }

    public SimpleStringProperty nodeIdProperty() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId.set(nodeId);
    }

    public String getDeforestationDetected() {
        return deforestationDetected.get();
    }

    public SimpleStringProperty deforestationDetectedProperty() {
        return deforestationDetected;
    }

    public void setDeforestationDetected(String deforestationDetected) {
        this.deforestationDetected.set(deforestationDetected);
    }

    public String getDeforestationRemark() {
        return deforestationRemark.get();
    }

    public SimpleStringProperty deforestationRemarkProperty() {
        return deforestationRemark;
    }

    public void setDeforestationRemark(String deforestationRemark) {
        this.deforestationRemark.set(deforestationRemark);
    }
}
