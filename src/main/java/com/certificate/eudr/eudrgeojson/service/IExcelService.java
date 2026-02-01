package com.certificate.eudr.eudrgeojson.service;



import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IExcelService {

    public List<FarmDataWithPoint> excelToFarmDataList (File file) throws IOException;

    public boolean hasExcelFormat(File file) throws IOException;



}
