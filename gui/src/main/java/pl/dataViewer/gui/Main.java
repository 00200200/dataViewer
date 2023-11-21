package pl.dataViewer.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.dataViewer.client.api.ImgwApiClient;
import pl.dataViewer.client.db.StationRepository;
import pl.dataViewer.gui.controller.MainPaneController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/mainPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
        MainPaneController mainPaneController = fxmlLoader.getController();
        StationRepository stationRepository = new StationRepository();
        List<String> stationNames = stationRepository.getAllStationNames();
        mainPaneController.updateStationData(stationNames);

    }

    public static void main(String[] args) {


        launch();
    }
}