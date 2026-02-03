package com.certificate.eudr.eudrgeojson.controller.service;



import com.certificate.eudr.eudrgeojson.controller.entities.FeatureCollection;
import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;

import java.io.IOException;
import java.util.List;

public interface IGeoJsonService {


    public FeatureCollection getPointFeatureCollection(List<FarmDataWithPoint> farmDataList);

    public String getPointGeoJson(List<FarmDataWithPoint> farmDataList) throws IOException;

}
