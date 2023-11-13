module ive.statera {
    requires javafx.controls;
    requires javafx.fxml;

    opens ive.statera to javafx.fxml;
    exports ive.statera;

    opens controllers to javafx.fxml;
    exports controllers;

    opens models to javafx.fxml;
    exports models;

    exports enums;
    opens enums to javafx.fxml;
}