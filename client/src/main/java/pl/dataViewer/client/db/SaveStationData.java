package pl.dataViewer.client.db;
import pl.dataViewer.client.data.StationData;

import java.sql.*;
import java.util.List;

 // POZNIEJ DODAC ODCZYTYWANIE URL ITP Z PLIKU .PROPERTIES
//import java.util.Properties;

public class SaveStationData {
    public void saveStationData(List<StationData> data){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataViewer","root","haslohaslo")){
            String sqlInsert = "INSERT INTO synop_data (id_stacji, nazwa_stacji, data_pomiaru, godzina_pomiaru, temperatura, predkosc_wiatru, kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String sqlCheckIfInDataBase = "SELECT id_stacji from synop_data where id_stacji = ? AND data_pomiaru = ?";
            for(StationData item : data) {
                boolean exists = false;
                try (PreparedStatement check = connection.prepareStatement(sqlCheckIfInDataBase)) {
                    check.setInt(1, item.getStationId());
                    check.setDate(2, java.sql.Date.valueOf(item.getDate()));
                    ResultSet resp = check.executeQuery();
                    if (!resp.next()) {
                        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {
                            preparedStatement.setInt(1, item.getStationId());
                            preparedStatement.setString(2, item.getStation());
                            preparedStatement.setDate(3, java.sql.Date.valueOf(item.getDate()));
                            preparedStatement.setInt(4, item.getHour());
                            preparedStatement.setDouble(5, item.getTemperature());
                            preparedStatement.setDouble(6, item.getWindSpeed());
                            preparedStatement.setDouble(7, item.getWindDirection());
                            preparedStatement.setDouble(8, item.getHumidity());
                            preparedStatement.setDouble(9, item.getRainFall());
                            preparedStatement.setDouble(10, item.getPressure());
                            preparedStatement.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
