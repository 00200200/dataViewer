module gui {
    requires client;

    requires javafx.controls;
    requires javafx.fxml;


    opens pl.dataViewer.gui to javafx.fxml;
    exports pl.dataViewer.gui;
}