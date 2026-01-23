module com.certificate.eudr.eudrgeojson {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.certificate.eudr.eudrgeojson to javafx.fxml;
    exports com.certificate.eudr.eudrgeojson;
}