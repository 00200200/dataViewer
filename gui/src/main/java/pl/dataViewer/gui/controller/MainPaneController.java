package pl.dataViewer.gui.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.dataViewer.client.data.StationData;
import pl.dataViewer.client.db.StationRepository;

import java.util.List;

public class MainPaneController {

    @FXML
    private CheckBox date;

    @FXML
    private CheckBox hour;

    @FXML
    private CheckBox humidity;
    @FXML
    private CheckBox pressure;
    @FXML
    private CheckBox rainFall;
    @FXML
    private CheckBox station;

    @FXML
    private CheckBox stationId;

    @FXML
    private CheckBox temperature;

    @FXML
    private CheckBox windDirection;

    @FXML
    private CheckBox windSpeed;


    @FXML
    public TableView<String> mainPaneTable;
    @FXML
    public TableColumn<String, String> mainPaneColumn;

    @FXML
    public void initialize() {
        mainPaneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }


    public void onClick() {
        StationRepository stationRepository = new StationRepository();
        String selectedItem = mainPaneTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            List<StationData> data = stationRepository.getAllCheckedStations(mainPaneTable.getSelectionModel().getSelectedItem(), stationId.isSelected(), station.isSelected(), date.isSelected(), hour.isSelected(), temperature.isSelected(), windSpeed.isSelected(), windDirection.isSelected(), humidity.isSelected(), rainFall.isSelected(), pressure.isSelected());
            openDataPanel(data, selectedItem, stationId.isSelected(), station.isSelected(), date.isSelected(), hour.isSelected(), temperature.isSelected(), windSpeed.isSelected(), windDirection.isSelected(), humidity.isSelected(), rainFall.isSelected(), pressure.isSelected());

        }
    }

    @FXML
    private void openDataPanel(List<StationData> data, String stationName, boolean stationId, boolean station, boolean date, boolean hour, boolean temperature, boolean windSpeed, boolean windDirection,
                               boolean humidity, boolean rainFall, boolean pressure) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/dataPanel.fxml"));
            Scene scene = new Scene(loader.load());
            DataPanelController controller = loader.getController();
            controller.displayData(data, stationId, station, date, hour, temperature, windSpeed, windDirection,
                    humidity, rainFall, pressure);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(stationName);
            stage.show();
            stage.toFront();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void updateStationData(List<String> data) {
        mainPaneTable.getItems().setAll(data);
    }

    public void loadData() {
    }

}
