package com.certificate.eudr.eudrgeojson.entities;

public class FarmDataWithPoint extends FarmData{


    private long id;
    private Integer year;
    private String farmerId;
    private String farmerName;
    private String farmId;
    private String farmName;
    private String farmGroup;
    private Double farmYield;
    private Double farmSize;
    private Double gpsLatitude;
    private Double gpsLongitude;

    //TRACT related attributes
    private String plotId;
    private String nodeId;
    private Integer deforestationDetected;
    private String deforestationRemark;


    private Long createdBy;


    private Long lastModifiedDate;


    private Long lastModifiedBy;


    private Integer dmlFlag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmGroup() {
        return farmGroup;
    }

    public void setFarmGroup(String farmGroup) {
        this.farmGroup = farmGroup;
    }

    public Double getFarmYield() {
        return farmYield;
    }

    public void setFarmYield(Double farmYield) {
        this.farmYield = farmYield;
    }

    public Double getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(Double farmSize) {
        this.farmSize = farmSize;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getDmlFlag() {
        return dmlFlag;
    }

    public void setDmlFlag(Integer dmlFlag) {
        this.dmlFlag = dmlFlag;
    }

    public String getPlotId() {
        return plotId;
    }

    public void setPlotId(String plotId) {
        this.plotId = plotId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getDeforestationDetected() {
        return deforestationDetected;
    }

    public void setDeforestationDetected(Integer deforestationDetected) {
        this.deforestationDetected = deforestationDetected;
    }
}
