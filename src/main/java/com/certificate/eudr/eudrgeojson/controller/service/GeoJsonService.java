package com.certificate.eudr.eudrgeojson.controller.service;


import com.certificate.eudr.eudrgeojson.controller.entities.Feature;
import com.certificate.eudr.eudrgeojson.controller.entities.FeatureCollection;
import com.certificate.eudr.eudrgeojson.controller.entities.PointGeometry;
import com.certificate.eudr.eudrgeojson.controller.entities.Property;
import com.certificate.eudr.eudrgeojson.entities.FarmData;
import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class GeoJsonService implements IGeoJsonService{

    private final String POINT = "Point";
    private final String POLYGON = "Polygon";
    private final String MULTI_POINT = "MultiPoint";
    private final String FILE_NAME = "FeatureCollection";
    private final String FILE_EXTENSION = ".geojson";
    private final String TRACT_POINT = "TRACT-point-ET-PRIM";


    @Override
    public FeatureCollection getPointFeatureCollection(List<FarmDataWithPoint> farmDataList) {
        FeatureCollection featureCollection;
        if(farmDataList == null || farmDataList.isEmpty()) {
            return null;
        } else {
            featureCollection = new FeatureCollection();
            List<Feature> featureList = new ArrayList<Feature>();
            Feature feature;
            Property property;
            PointGeometry pointGeometry;
            FarmDataWithPoint farmDataWithPoint;
            Double[] coordinate;
            for(FarmData farmData : farmDataList) {
                feature = new Feature();
                property = new Property();
                pointGeometry = new PointGeometry();
                coordinate = new Double[2];

                farmDataWithPoint = (FarmDataWithPoint) farmData;
                //map property attributes
                property.setProducerName(farmDataWithPoint.getFarmerName());
                property.setProductionPlace(farmDataWithPoint.getFarmGroup());
                property.setArea(farmDataWithPoint.getFarmSize());
                property.setPlotID(farmDataWithPoint.getPlotId());
                property.setNodeID(farmDataWithPoint.getNodeId());

                //map geometry attributes
                coordinate[0] = farmDataWithPoint.getGpsLongitude();
                coordinate[1] = farmDataWithPoint.getGpsLatitude();

                pointGeometry.setType(POINT);
                pointGeometry.setCoordinates(coordinate);

                feature.setProperties(property);
                feature.setGeometry(pointGeometry);

                featureList.add(feature);
            }

            featureCollection.setName(TRACT_POINT);
            featureCollection.setFeatures(featureList);
            return featureCollection;
        }

    }



    @Override
    public String getPointGeoJson(List<FarmDataWithPoint> farmDataList) throws IOException {
        FeatureCollection featureCollection;
        featureCollection = getPointFeatureCollection(farmDataList);
//        String filePath = FILE_NAME + " " + getTimeStamp() + FILE_EXTENSION;
        String jsonContent;
        Gson gson = new Gson();
        jsonContent = gson.toJson(featureCollection);
//        FileWriter writer = new FileWriter(filePath);
//        writer.write(jsonContent);
//        writer.close();
        return jsonContent;
    }



    private Double[] getSingleCoordinates(String coordinatesAsString) {
        Double[] singleCoordinates;
        String[] singleCoordinateArray;
        singleCoordinates = new Double[2];
        singleCoordinateArray = coordinatesAsString.split(",");
        singleCoordinates[0] = Double.parseDouble(singleCoordinateArray[0]);
        singleCoordinates[1] = Double.parseDouble(singleCoordinateArray[1]);
        return singleCoordinates;
    }


    private Double[][] getMultipleCoordinates(String coordinatesAsString, int points) {
        Double[] singleCoordinates;
        Double[][] coordinates;
        String[] coordinatesArray;
        String[] singleCoordinateArray;
        coordinates = new Double[points][2];
        coordinatesArray = coordinatesAsString.split("\\|");
        for(int i =0; i < coordinatesArray.length; i++){
            singleCoordinates = new Double[2];
            singleCoordinateArray = coordinatesArray[i].split(",");
            singleCoordinates[0] = Double.parseDouble(singleCoordinateArray[0]);
            singleCoordinates[1] = Double.parseDouble(singleCoordinateArray[1]);
            coordinates[i] = singleCoordinates;
        }
        return coordinates;
    }


    private Double[][] getPolygonCoordinates(String coordinatesAsString, int points) {
        int extraCoordinates = points + 1;
        Double[] singleCoordinates;
        Double[][] coordinates;
        String[] coordinatesArray;
        String[] singleCoordinateArray;
        coordinates = new Double[extraCoordinates][2];
        coordinatesArray = coordinatesAsString.split("\\|");
        for(int i =0; i < coordinatesArray.length; i++){
            singleCoordinates = new Double[2];
            singleCoordinateArray = coordinatesArray[i].split(",");
            singleCoordinates[0] = Double.parseDouble(singleCoordinateArray[0]);
            singleCoordinates[1] = Double.parseDouble(singleCoordinateArray[1]);
            coordinates[i] = singleCoordinates;
        }

        //make a loop by adding the first coordinate as last coordinate
        coordinates[extraCoordinates - 1] = coordinates[0];

        return coordinates;
    }

//    private String getTimeStamp(){
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//        return now.format(formatter);
//    }

}
