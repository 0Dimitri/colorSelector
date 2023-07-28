module com.dimitri.colorfx {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.dimitri.colorfx.models;
    opens com.dimitri.colorfx.models to javafx.fxml;
    exports com.dimitri.colorfx.controllers;
    opens com.dimitri.colorfx.controllers to javafx.fxml;
    exports com.dimitri.colorfx;
    opens com.dimitri.colorfx to javafx.graphics;
}