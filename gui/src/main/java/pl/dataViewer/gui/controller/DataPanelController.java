package pl.dataViewer.gui.controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.dataViewer.client.data.StationData;
import java.util.List;

public class DataPanelController {
    @FXML
    TableView<StationData> dataPanelTable;

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
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("hour"));
                } if(item.getTemperature() != null){
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("temperature"));
                } if(item.getWindSpeed() != null){
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("windSpeed"));
                } if(item.getHumidity() != null){
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("humidity"));
                } if(item.getRainFall() != null){
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("rainFall"));
                } if(item.getPressure() != null){
                    stationTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("pressure"));
                }
            }

            dataPanelTable.getItems().setAll(data);
        }

    }

//    private boolean columnExists(String columNaem){
//        return dataPanelTable.getColumns().stream().anyMatch(col -> col.getText().equals(columNaem));
//    }
}
