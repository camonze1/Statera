module ive.statera {
    requires javafx.controls;
    requires javafx.fxml;


    opens ive.statera to javafx.fxml;
    exports ive.statera;
}