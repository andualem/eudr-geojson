package com.certificate.eudr.eudrgeojson.controller;

import com.certificate.eudr.eudrgeojson.controller.service.GeoJsonService;
import com.certificate.eudr.eudrgeojson.controller.service.IGeoJsonService;
import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;
import com.certificate.eudr.eudrgeojson.service.ExcelService;
import com.certificate.eudr.eudrgeojson.service.IExcelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExcelToJsonController {

    @FXML
    private TextField filePathField;

    @FXML
    private TableView<FarmDataWithPoint> eudrDataTable;

//    @FXML
    private TableColumn<FarmDataWithPoint, Integer> year;

//    @FXML
    private TableColumn<FarmDataWithPoint, String> farmerId;

//    @FXML
    private TableColumn<FarmDataWithPoint, String> farmerName;

//    @FXML
    private TableColumn<FarmDataWithPoint, String> farmId;

//    @FXML
    private TableColumn<FarmDataWithPoint, String> farmName;

//    @FXML
    private TableColumn<FarmDataWithPoint, String> farmGroup;

//    @FXML
    private TableColumn<FarmDataWithPoint, Double> farmYield;

//    @FXML
    private TableColumn<FarmDataWithPoint, Double> farmSize;

//    @FXML
    private TableColumn<FarmDataWithPoint, Double> gpsLatitude;

//    @FXML
    private TableColumn<FarmDataWithPoint, Double> gpsLongitude;

//    @FXML
    private TableColumn<FarmDataWithPoint, Double> plotId;

//    @FXML
    private TableColumn<FarmDataWithPoint, Double> nodeId;


    private File selectedFile;

    private IExcelService excelService;

    private IGeoJsonService geoJsonService;

    private List<FarmDataWithPoint> farmDataWithPointList;

    @FXML
    protected void handleFileSelection(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Excel file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx", "*.xls"));

        Stage stage = (Stage) filePathField.getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    protected void handleUploadAction(ActionEvent event) throws IOException {
        if (selectedFile != null) {

            excelService = new ExcelService();
            farmDataWithPointList = excelService.excelToFarmDataList(selectedFile);
            populateTableView(farmDataWithPointList);
            System.out.println("Size of data is : " + farmDataWithPointList.size());
        } else {
            System.out.println("No file selected.");
        }

    }

    private void populateTableView(List<FarmDataWithPoint> farmDataWithPointList) {
        ObservableList<FarmDataWithPoint> observableList = FXCollections.observableArrayList(farmDataWithPointList);
        eudrDataTable.setItems(observableList);
        year = new TableColumn<>("year");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        farmerId = new TableColumn<>("farmerId");
        farmerId.setCellValueFactory(new PropertyValueFactory<>("farmerId"));

        farmerName = new TableColumn<>("farmerName");
        farmerName.setCellValueFactory(new PropertyValueFactory<>("farmerName"));

        farmId = new TableColumn<>("farmId");
        farmId.setCellValueFactory(new PropertyValueFactory<>("farmId"));

        farmName = new TableColumn<>("farmName");
        farmName.setCellValueFactory(new PropertyValueFactory<>("farmName"));

        farmGroup = new TableColumn<>("farmGroup");
        farmGroup.setCellValueFactory(new PropertyValueFactory<>("farmGroup"));

        farmYield = new TableColumn<>("farmYield");
        farmYield.setCellValueFactory(new PropertyValueFactory<>("farmYield"));

        farmSize = new TableColumn<>("farmSize");
        farmSize.setCellValueFactory(new PropertyValueFactory<>("farmSize"));

        gpsLatitude = new TableColumn<>("gpsLatitude");
        gpsLatitude.setCellValueFactory(new PropertyValueFactory<>("gpsLatitude"));

        gpsLongitude = new TableColumn<>("gpsLongitude");
        gpsLongitude.setCellValueFactory(new PropertyValueFactory<>("gpsLongitude"));

        nodeId = new TableColumn<>("nodeId");
        nodeId.setCellValueFactory(new PropertyValueFactory<>("nodeId"));

        plotId = new TableColumn<>("plotId");
        plotId.setCellValueFactory(new PropertyValueFactory<>("plotId"));

        eudrDataTable.getColumns().addAll(year, farmerId, farmerName, farmId, farmName, farmGroup,
                farmYield, farmSize, gpsLatitude, gpsLongitude, nodeId, plotId);



    }


    @FXML
    protected void handleDownloadAction (ActionEvent event) {
        if (farmDataWithPointList != null && !farmDataWithPointList.isEmpty()){
            geoJsonService = new GeoJsonService();
            try {
                geoJsonService.getPointGeoJson(farmDataWithPointList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}