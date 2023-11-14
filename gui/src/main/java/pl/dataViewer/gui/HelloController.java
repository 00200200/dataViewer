package pl.dataViewer.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
//        Main.name = "nowa nazwa";
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}