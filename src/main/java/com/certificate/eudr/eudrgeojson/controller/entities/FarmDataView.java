package com.certificate.eudr.eudrgeojson.controller.entities;

import javafx.beans.property.*;

public class FarmDataView {


    private StringProperty id;
    private IntegerProperty year;
    private StringProperty farmerId;
    private StringProperty farmerName;
    private StringProperty farmId;
    private StringProperty farmName;
    private StringProperty farmGroup;
    private DoubleProperty farmYield;
    private DoubleProperty farmSize;
    private DoubleProperty gpsLatitude;
    private DoubleProperty gpsLongitude;

    //TRACT related attributes
    private StringProperty plotId;
    private StringProperty nodeId;
    private StringProperty deforestationDetected;
    private StringProperty deforestationRemark;


    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public String getFarmerId() {
        return farmerId.get();
    }

    public StringProperty farmerIdProperty() {
        return farmerId;
    }

    public String getFarmerName() {
        return farmerName.get();
    }

    public StringProperty farmerNameProperty() {
        return farmerName;
    }

    public String getFarmId() {
        return farmId.get();
    }

    public StringProperty farmIdProperty() {
        return farmId;
    }

    public String getFarmName() {
        return farmName.get();
    }

    public StringProperty farmNameProperty() {
        return farmName;
    }

    public String getFarmGroup() {
        return farmGroup.get();
    }

    public StringProperty farmGroupProperty() {
        return farmGroup;
    }

    public double getFarmYield() {
        return farmYield.get();
    }

    public DoubleProperty farmYieldProperty() {
        return farmYield;
    }

    public double getFarmSize() {
        return farmSize.get();
    }

    public DoubleProperty farmSizeProperty() {
        return farmSize;
    }

    public double getGpsLatitude() {
        return gpsLatitude.get();
    }

    public DoubleProperty gpsLatitudeProperty() {
        return gpsLatitude;
    }

    public double getGpsLongitude() {
        return gpsLongitude.get();
    }

    public DoubleProperty gpsLongitudeProperty() {
        return gpsLongitude;
    }

    public String getPlotId() {
        return plotId.get();
    }

    public StringProperty plotIdProperty() {
        return plotId;
    }

    public String getNodeId() {
        return nodeId.get();
    }

    public StringProperty nodeIdProperty() {
        return nodeId;
    }

    public String getDeforestationDetected() {
        return deforestationDetected.get();
    }

    public StringProperty deforestationDetectedProperty() {
        return deforestationDetected;
    }

    public String getDeforestationRemark() {
        return deforestationRemark.get();
    }

    public StringProperty deforestationRemarkProperty() {
        return deforestationRemark;
    }



    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }


    public void setFarmerId(String farmerId) {
        this.farmerId =  new SimpleStringProperty(farmerId);
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = new SimpleStringProperty(farmerName);
    }

    public void setFarmId(String farmId) {
        this.farmId =  new SimpleStringProperty(farmId);
    }

    public void setFarmName(String farmName) {
        this.farmName = new SimpleStringProperty(farmName);
    }

    public void setFarmGroup(String farmGroup) {
        this.farmGroup = new SimpleStringProperty(farmGroup);
    }


    public void setYear(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    public void setFarmYield(double farmYield) {
        this.farmYield = new SimpleDoubleProperty(farmYield);
    }

    public void setFarmSize(double farmSize) {
        this.farmSize = new SimpleDoubleProperty(farmSize);
    }

    public void setGpsLatitude(double gpsLatitude) {
        this.gpsLatitude = new SimpleDoubleProperty(gpsLatitude);
    }

    public void setGpsLongitude(double gpsLongitude) {
        this.gpsLongitude = new SimpleDoubleProperty(gpsLongitude);
    }

    public void setPlotId(String plotId) {
        this.plotId = new SimpleStringProperty(plotId);
    }

    public void setNodeId(String nodeId) {
        this.nodeId = new SimpleStringProperty(nodeId);
    }

    public void setDeforestationDetected(String deforestationDetected) {
        this.deforestationDetected = new SimpleStringProperty(deforestationDetected);
    }

    public void setDeforestationRemark(String deforestationRemark) {
        this.deforestationRemark = new SimpleStringProperty(deforestationRemark);
    }
}
