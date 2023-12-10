package pl.dataViewer.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.dataViewer.client.data.StationData;

import java.util.List;

public class DataPanelController {
    @FXML
    ListView<String> DataPanelListView;
    @FXML
    TableView<StationData> dataPanelTable;
    @FXML
    LineChart<String, Number> temperatureGraph;

    List<StationData> data;

    public List<StationData> getData() {
        return data;
    }

    public void setData(List<StationData> data) {
        this.data = data;
    }

    public void displayData(List<StationData> data, boolean stationId, boolean station, boolean date, boolean hour, boolean temperature, boolean windSpeed, boolean windDirection,
                            boolean humidity, boolean rainFall, boolean pressure) {
        if (!data.isEmpty()) {

            System.out.println(temperature);
            System.out.println(windSpeed);
            System.out.println(windDirection);
            System.out.println(humidity);
            System.out.println(rainFall);
            System.out.println(pressure);
            dataPanelTable.getColumns().clear();
            TableColumn<StationData, String> stationTableColumnId = new TableColumn<>("id_stacji");
            TableColumn<StationData, String> stationTableColumnName = new TableColumn<>("nazwa_stacji");
            TableColumn<StationData, String> stationTableColumnDate = new TableColumn<>("data_pomiaru");
            TableColumn<StationData, String> stationTableColumnHour = new TableColumn<>("godzina_pomiaru");
            TableColumn<StationData, String> stationTableColumnTemperature = new TableColumn<>("temperatura");
            TableColumn<StationData, String> stationTableColumnWindSpeed = new TableColumn<>("predkosc_wiatru");
            TableColumn<StationData, String> stationTableColumnWindDirection = new TableColumn<>("kierunek_wiatru");
            TableColumn<StationData, String> stationTableColumnHumidity = new TableColumn<>("wilgotnosc_wzgledna");
            TableColumn<StationData, String> stationTableColumnRainFall = new TableColumn<>("suma_opadu");
            TableColumn<StationData, String> stationTableColumnpressure = new TableColumn<>("cisnienie");
            if (stationId) {
                dataPanelTable.getColumns().add(stationTableColumnId);
                stationTableColumnId.setCellValueFactory(new PropertyValueFactory<>("stationId"));
            }
            if (station) {
                dataPanelTable.getColumns().add(stationTableColumnName);
                stationTableColumnName.setCellValueFactory(new PropertyValueFactory<>("station"));
            }
            if (date) {
                dataPanelTable.getColumns().add(stationTableColumnDate);
                stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            }
            if (hour) {
                DataPanelListView.getItems().add("godzina");
                dataPanelTable.getColumns().add(stationTableColumnHour);
                stationTableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));

            }
            if (temperature) {
                dataPanelTable.getColumns().add(stationTableColumnTemperature);
                DataPanelListView.getItems().add("temperatura");
                stationTableColumnTemperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));


            }
            if (windSpeed) {
                dataPanelTable.getColumns().add(stationTableColumnWindSpeed);
                DataPanelListView.getItems().add("predkosc wiatru");
                stationTableColumnWindSpeed.setCellValueFactory(new PropertyValueFactory<>("windSpeed"));
            }
            if (windDirection) {
                dataPanelTable.getColumns().add(stationTableColumnWindDirection);
                DataPanelListView.getItems().add("kierunek wiatru");
                stationTableColumnWindDirection.setCellValueFactory(new PropertyValueFactory<>("windDirection"));


            }
            if (humidity) {
                dataPanelTable.getColumns().add(stationTableColumnHumidity);
                DataPanelListView.getItems().add("wilgotnosc");
                stationTableColumnHumidity.setCellValueFactory(new PropertyValueFactory<>("humidity"));

            }
            if (rainFall) {
                dataPanelTable.getColumns().add(stationTableColumnRainFall);
                DataPanelListView.getItems().add("opady deszczu");
                stationTableColumnRainFall.setCellValueFactory(new PropertyValueFactory<>("rainFall"));

            }
            if (pressure) {
                dataPanelTable.getColumns().add(stationTableColumnpressure);
                DataPanelListView.getItems().add("cisnienie");
                stationTableColumnpressure.setCellValueFactory(new PropertyValueFactory<>("pressure"));

            }

            dataPanelTable.getItems().setAll(data);
            setData(data);
        }
    }

    public void updateGraph() {
        List<StationData> data = getData();
        String selectedItem = DataPanelListView.getSelectionModel().getSelectedItem();
        temperatureGraph.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        if (selectedItem != null) {
            switch (selectedItem) {
                case "godzina":
                    temperatureGraph.getData().clear();
                    series.setName("Godzina Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getHour() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getHour()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;
                case "temperatura":
                    series.setName("Temperatura Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getTemperature() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getTemperature()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;
                case "predkosc wiatru":
                    series.setName("Predkosc Wiatru Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getWindSpeed() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getWindSpeed()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;
                case "opady deszczu":
                    series.setName("Wilgotnosc Wiatru Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getRainFall() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getRainFall()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;

                case "cisnienie":
                    series.setName("cisnienie Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getPressure() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getPressure()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;
                case "wilgotnosc":
                    series.setName("Wilgotnosc Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getHumidity() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getHumidity()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;
                case "kierunek wiatru":
                    series.setName("kierunek Wiatru Wykres");
                    for (StationData item : data) {
                        if (item.getDate() != null && item.getWindDirection() != null) {
                            String dataString = item.getDate().toString();
                            series.getData().add(new XYChart.Data<>(dataString, item.getWindDirection()));
                        }
                    }
                    temperatureGraph.getData().add(series);
                    break;
                default:

            }
        }


    }
}
