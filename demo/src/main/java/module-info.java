module eyad {
    requires javafx.controls;
    requires javafx.fxml;

    opens eyad to javafx.fxml;
    exports eyad;
}
