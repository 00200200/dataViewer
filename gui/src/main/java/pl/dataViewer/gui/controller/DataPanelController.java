package pl.dataViewer.gui.controller;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.dataViewer.client.data.StationData;
import java.util.List;

public class DataPanelController {
    @FXML
    TableView<StationData> dataPanelTable;
    @FXML
    LineChart<String,Number> temperatureGraph;

    public void displayData(List<StationData> data){
        if(!data.isEmpty()){
            dataPanelTable.getColumns().clear();
            StationData firstItem = data.get(0);
            TableColumn<StationData, String>  stationTableColumnId = new TableColumn<>("id_stacji");
            TableColumn<StationData, String>  stationTableColumnName = new TableColumn<>("nazwa_stacji");
            TableColumn<StationData, String>  stationTableColumnDate = new TableColumn<>("data_pomiaru");
            TableColumn<StationData, String>  stationTableColumnHour = new TableColumn<>("godzina_pomiaru");
            TableColumn<StationData, String>  stationTableColumnTemperature = new TableColumn<>("temperatura");
            TableColumn<StationData, String>  stationTableColumnWindSpeed = new TableColumn<>("predkosc_wiatru");
            TableColumn<StationData, String>  stationTableColumnWindDirection = new TableColumn<>("kierunek_wiatru");
            TableColumn<StationData, String>  stationTableColumnHumidity = new TableColumn<>("wilgotnosc_wzgledna");
            TableColumn<StationData, String>  stationTableColumnRainFall = new TableColumn<>("suma_opadu");
            TableColumn<StationData, String>  stationTableColumnpressure = new TableColumn<>("cisnienie");
            if(firstItem.getStationId() != null) {
                dataPanelTable.getColumns().add(stationTableColumnId);
            }
            if(firstItem.getStation() != null){
                dataPanelTable.getColumns().add(stationTableColumnName);
            }
            if(firstItem.getDate() != null){
                dataPanelTable.getColumns().add(stationTableColumnDate);
            }if(firstItem.getHour() != null){
                dataPanelTable.getColumns().add(stationTableColumnHour);
            }if(firstItem.getTemperature() != null){
                dataPanelTable.getColumns().add(stationTableColumnTemperature);
            }if(firstItem.getWindSpeed() != null){
                dataPanelTable.getColumns().add(stationTableColumnWindSpeed);
            }if(firstItem.getHumidity() != null){
                dataPanelTable.getColumns().add(stationTableColumnHumidity);
            }if(firstItem.getRainFall() != null){
                dataPanelTable.getColumns().add(stationTableColumnRainFall);
            }if(firstItem.getPressure() != null){
                dataPanelTable.getColumns().add(stationTableColumnpressure);
            }if(firstItem.getWindDirection() != null){
                dataPanelTable.getColumns().add(stationTableColumnWindDirection);
            }
            for(StationData item : data){
                if(item.getStationId() != null){
                    stationTableColumnId.setCellValueFactory(new PropertyValueFactory<>("stationId"));
                }
                if(item.getStation() != null){
                    stationTableColumnName.setCellValueFactory(new PropertyValueFactory<>("station"));
                }
                if(item.getDate() != null){
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
                } if(item.getHour() != null){
                    stationTableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
                } if(item.getTemperature() != null){
                    stationTableColumnTemperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
                } if(item.getWindSpeed() != null){
                    stationTableColumnWindSpeed.setCellValueFactory(new PropertyValueFactory<>("windSpeed"));
                } if(item.getWindSpeed() != null){
                    stationTableColumnWindDirection.setCellValueFactory(new PropertyValueFactory<>("windDirection"));
                } if(item.getHumidity() != null){
                    stationTableColumnHumidity.setCellValueFactory(new PropertyValueFactory<>("humidity"));
                } if(item.getRainFall() != null){
                    stationTableColumnRainFall.setCellValueFactory(new PropertyValueFactory<>("rainFall"));
                } if(item.getPressure() != null){
                    stationTableColumnpressure.setCellValueFactory(new PropertyValueFactory<>("pressure"));
                }
            }

            dataPanelTable.getItems().setAll(data);

            updateGraph(data);
        }
    }

    public void updateGraph(List<StationData> data){
        temperatureGraph.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Temperature Graph");

        for(StationData item : data){
            if(item.getDate() != null && item.getPressure() != null) {
                String dataString = item.getDate().toString();
                series.getData().add(new XYChart.Data<>(dataString, item.getTemperature()));
            }
        }
        temperatureGraph.getData().add(series);
    }
}
