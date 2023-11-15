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
            if(firstItem.getStationId() != null) {
                dataPanelTable.getColumns().add(stationTableColumnId);
            }
            if(firstItem.getStation() != null){
                dataPanelTable.getColumns().add(stationTableColumnName);
            }
            if(firstItem.getDate() != null){
                dataPanelTable.getColumns().add(stationTableColumnDate);
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
                }
            }

            dataPanelTable.getItems().setAll(data);
        }

    }

//    private boolean columnExists(String columNaem){
//        return dataPanelTable.getColumns().stream().anyMatch(col -> col.getText().equals(columNaem));
//    }
}
