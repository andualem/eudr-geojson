package com.certificate.eudr.eudrgeojson.service;

import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelService implements IExcelService{


    private static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static String[] HEADERS = {"farm_group", "farm_id", "farm_name", "farm_size",
            "farm_yield", "farmer_id", "farmer_name", "gps_latitude",
            "gps_longitude", "year", "node_id", "plot_id"};

    private static String SHEET_NAME = "eudr";


//    private String fileType;
//    private String[] columnHeader;
//    private String sheetName;

//    public ExcelService(String fileType, String[] columnHeader, String sheetName) {
//        this.fileType = TYPE;
//        this.columnHeader = HEADERS;
//        this.sheetName = SHEET;
//    }


    @Override
    public List<FarmDataWithPoint> excelToFarmDataList(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file.getPath());

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        Iterator<Row> rowIterator = sheet.rowIterator();
        int rowNumber = 0;

        List<FarmDataWithPoint> farmDataList = new ArrayList<FarmDataWithPoint>();
        FarmDataWithPoint farmData;
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();
            farmData = new FarmDataWithPoint();

            //skip header
            if(rowNumber == 0){
                rowNumber++;
                continue;
            }


            Iterator<Cell> cellIterator = row.cellIterator();

            int cellNumber = 0;

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cellNumber = cell.getColumnIndex();

                switch (cellNumber){
                    case 0:
                        farmData.setFarmGroup(cell.getStringCellValue());
                        break;
                    case 1:
                        farmData.setFarmId(cell.getStringCellValue());
                        break;
                    case 2:
                        farmData.setFarmName(cell.getStringCellValue());
                        break;
                    case 3:
                        farmData.setFarmSize(cell.getNumericCellValue());
                        break;
                    case 4:
                        farmData.setFarmYield(cell.getNumericCellValue());
                        break;
                    case 5:
                        farmData.setFarmerId(cell.getStringCellValue());
                        break;
                    case 6:
                        farmData.setFarmerName(cell.getStringCellValue());
                        break;
                    case 7:
                        farmData.setGpsLatitude(cell.getNumericCellValue());
                        break;
                    case 8:
                        farmData.setGpsLongitude(cell.getNumericCellValue());
                        break;
                    case 9:
                        farmData.setYear((int) cell.getNumericCellValue());
                        break;
                    case 10:
                        farmData.setNodeId(cell.getStringCellValue());
                        break;
                    case 11:
                        farmData.setPlotId(cell.getStringCellValue());
                        break;
                    default:
                        break;
                }
            }
            farmDataList.add(farmData);
            rowNumber++;
        }

        workbook.close();
        inputStream.close();
        return farmDataList;
    }

    @Override
    public boolean hasExcelFormat(File file) throws IOException {
      Path path = Path.of(file.getPath());
      return Files.probeContentType(path).equals(TYPE);
    }


}
