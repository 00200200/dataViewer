module gui {
    requires client;

    requires javafx.controls;
    requires javafx.fxml;

    exports pl.dataViewer.gui.controller to javafx.fxml;
    opens pl.dataViewer.gui.controller to javafx.fxml;
    exports pl.dataViewer.gui;
}