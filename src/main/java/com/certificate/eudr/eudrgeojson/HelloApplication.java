package com.certificate.eudr.eudrgeojson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("excelToJson.fxml"));

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double percentage = 0.75;
        double width = visualBounds.getWidth() * percentage;
        double height = visualBounds.getHeight() * percentage;

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("EUDR - GEOJSON Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}