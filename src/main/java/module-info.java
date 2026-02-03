module com.certificate.eudr.eudrgeojson {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires com.google.gson;


    opens com.certificate.eudr.eudrgeojson to javafx.fxml;
    exports com.certificate.eudr.eudrgeojson;
    exports com.certificate.eudr.eudrgeojson.controller;
    opens com.certificate.eudr.eudrgeojson.controller to javafx.fxml;
}