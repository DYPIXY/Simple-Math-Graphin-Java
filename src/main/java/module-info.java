module com.simple.graphin {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.simple.graphin to javafx.fxml;
    exports com.simple.graphin;
}
