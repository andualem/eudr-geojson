package com.certificate.eudr.eudrgeojson.service;



import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;

import java.io.IOException;
import java.util.List;

public interface IExcelService {

    public List<FarmDataWithPoint> excelToFarmDataList (MultipartFile multipartFile) throws IOException;

    public boolean hasExcelFormat(MultipartFile multipartFile);



}
