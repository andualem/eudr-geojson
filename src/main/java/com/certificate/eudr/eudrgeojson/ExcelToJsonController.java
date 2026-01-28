package com.certificate.eudr.eudrgeojson;

import com.certificate.eudr.eudrgeojson.entities.FarmDataWithPoint;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ExcelToJsonController {
    public TableColumn<FarmDataWithPoint, String> year;

    @FXML
    private TextField filePathField;

    private File selectedFile;

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
    protected void handleUploadAction(ActionEvent event) {
        if (selectedFile != null) {
            System.out.println(selectedFile.getAbsolutePath());
        } else {
            System.out.println("No file selected.");
        }

    }
}