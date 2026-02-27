package com.certificate.eudr.eudrgeojson.controller;

import com.certificate.eudr.eudrgeojson.controller.entities.FarmDataView;
import com.certificate.eudr.eudrgeojson.controller.service.GeoJsonService;
import com.certificate.eudr.eudrgeojson.controller.service.IGeoJsonService;
import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;
import com.certificate.eudr.eudrgeojson.service.ExcelService;
import com.certificate.eudr.eudrgeojson.service.IExcelService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExcelToJsonController {

    private final String FILE_NAME = "FeatureCollection";
    private final String FILE_EXTENSION = ".geojson";
    private String jsonFilePath;

    @FXML
    private TextField filePathField;

    @FXML
    private TableView<FarmDataView> eudrDataTable;

//    @FXML
    private TableColumn<FarmDataView, Number> year;

//    @FXML
    private TableColumn<FarmDataView, String> farmerId;

//    @FXML
    private TableColumn<FarmDataView, String> farmerName;

//    @FXML
    private TableColumn<FarmDataView, String> farmId;

//    @FXML
    private TableColumn<FarmDataView, String> farmName;

//    @FXML
    private TableColumn<FarmDataView, String> farmGroup;

//    @FXML
    private TableColumn<FarmDataView, Number> farmYield;

//    @FXML
    private TableColumn<FarmDataView, Number> farmSize;

//    @FXML
    private TableColumn<FarmDataView, Number> gpsLatitude;

//    @FXML
    private TableColumn<FarmDataView, Number> gpsLongitude;

//    @FXML
    private TableColumn<FarmDataView, String> plotId;

//    @FXML
    private TableColumn<FarmDataView, String> nodeId;

    @FXML
    private Text dataSizeTxt;

    @FXML
    private TextField directoryPathField;


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

            List<FarmDataView> farmDataViewList = mapFarmDataForView(farmDataWithPointList);

            populateTableView(farmDataViewList);

            dataSizeTxt.setText("Size of data : " + String.valueOf(farmDataWithPointList.size()));
            System.out.println("Size of data : " + farmDataWithPointList.size());
        } else {
            System.out.println("No file selected.");
        }

    }



    private void populateTableView(List<FarmDataView> farmDataViewList) {
        ObservableList<FarmDataView> observableList = FXCollections.observableArrayList(farmDataViewList);

        year = new TableColumn<>("year");
//        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        year.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getYear()));


        farmerId = new TableColumn<>("farmerId");
        farmerId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFarmerId()));

        farmerName = new TableColumn<>("farmerName");
        farmerName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFarmerName()));

        farmId = new TableColumn<>("farmId");
        farmId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFarmId()));

        farmName = new TableColumn<>("farmName");
        farmName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFarmerName()));

        farmGroup = new TableColumn<>("farmGroup");
        farmGroup.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFarmGroup()));

        farmYield = new TableColumn<>("farmYield");
        farmYield.setCellValueFactory(c -> new SimpleDoubleProperty((c.getValue().getFarmYield())));

        farmSize = new TableColumn<>("farmSize");
        farmSize.setCellValueFactory(c -> new SimpleDoubleProperty((c.getValue().getFarmSize())));

        gpsLatitude = new TableColumn<>("gpsLatitude");
        gpsLatitude.setCellValueFactory(c -> new SimpleDoubleProperty((c.getValue().getGpsLatitude())));

        gpsLongitude = new TableColumn<>("gpsLongitude");
        gpsLongitude.setCellValueFactory(c -> new SimpleDoubleProperty((c.getValue().getGpsLongitude())));

        nodeId = new TableColumn<>("nodeId");
        nodeId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNodeId()));

        plotId = new TableColumn<>("plotId");
        plotId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPlotId()));

        eudrDataTable.getColumns().addAll(year, farmerId, farmerName, farmId, farmName, farmGroup,
                farmYield, farmSize, gpsLatitude, gpsLongitude, nodeId, plotId);

        eudrDataTable.setItems(observableList);

    }


    private List<FarmDataView> mapFarmDataForView(List<FarmDataWithPoint> farmDataWithPointList) {
        List<FarmDataView> farmDataViewList;
        if(farmDataWithPointList != null && !farmDataWithPointList.isEmpty()) {
            farmDataViewList = new ArrayList<>(farmDataWithPointList.size());

            for(FarmDataWithPoint farmDataWithPoint : farmDataWithPointList) {
                FarmDataView farmDataView = new FarmDataView();
                farmDataView.setYear(farmDataWithPoint.getYear());
                farmDataView.setFarmId(String.valueOf(farmDataWithPoint.getFarmId()));
                farmDataView.setFarmName(String.valueOf(farmDataWithPoint.getFarmName()));
                farmDataView.setFarmerId(farmDataWithPoint.getFarmerId());
                farmDataView.setFarmerName(farmDataWithPoint.getFarmerName());
                farmDataView.setFarmGroup(farmDataWithPoint.getFarmGroup());
                farmDataView.setFarmYield(farmDataWithPoint.getFarmYield());
                farmDataView.setFarmSize(farmDataWithPoint.getFarmSize());
                farmDataView.setGpsLatitude(farmDataWithPoint.getGpsLatitude());
                farmDataView.setGpsLongitude(farmDataWithPoint.getGpsLongitude());
                farmDataView.setNodeId(farmDataWithPoint.getNodeId());
                farmDataView.setPlotId(farmDataWithPoint.getPlotId());
                farmDataViewList.add(farmDataView);
            }

            return farmDataViewList;
        }
        return null;
    }

    @FXML
    protected void handleDirSelection(ActionEvent event){
        Stage stage = (Stage) directoryPathField.getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Destination Folder");
        File selectedDirectory = directoryChooser.showDialog(stage);
        jsonFilePath = selectedDirectory.getAbsolutePath() + "/"
                + FILE_NAME + " " + getTimeStamp() + FILE_EXTENSION;
        directoryPathField.setText(jsonFilePath);
    }

    @FXML
    protected void handleDownloadAction (ActionEvent event) {
        if (farmDataWithPointList != null && !farmDataWithPointList.isEmpty()){
            geoJsonService = new GeoJsonService();
            try {
                String jsonContent = geoJsonService.getPointGeoJson(farmDataWithPointList);
                FileWriter writer = new FileWriter(jsonFilePath);
                writer.write(jsonContent);
                writer.close();

                showAlertDialog("Success", "Download completed successfully");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    @FXML
//    protected void handleDownloadTemplateAction(ActionEvent event){
//        showAlertDialog("template", "template");
//    }


    private void showAlertDialog (String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private String getTimeStamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }
}