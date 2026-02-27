package com.certificate.eudr.eudrgeojson.controller.entities.adapter;

import com.certificate.eudr.eudrgeojson.controller.entities.CRS;
import com.certificate.eudr.eudrgeojson.controller.entities.Feature;
import com.certificate.eudr.eudrgeojson.controller.entities.FeatureCollection;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;

public class FeatureCollectionAdapter extends TypeAdapter<FeatureCollection> {


    @Override
    public void write(JsonWriter jsonWriter, FeatureCollection featureCollection) throws IOException {

    }

    @Override
    public FeatureCollection read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
