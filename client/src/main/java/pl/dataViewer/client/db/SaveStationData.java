package pl.dataViewer.client.db;
import pl.dataViewer.client.data.StationData;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

// POZNIEJ DODAC ODCZYTYWANIE URL ITP Z PLIKU .PROPERTIES
//import java.util.Properties;

public class SaveStationData {

    private Properties loadProperties(){
        Properties properties = new Properties();
        try(FileInputStream input = new FileInputStream("client/src/main/resources/application.properties")){
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
    public void saveStationData(List<StationData> data){
        Properties properties = loadProperties();
        try(Connection connection = DriverManager.getConnection(properties.getProperty("db_url"),properties.getProperty("db_user"),properties.getProperty("db_password"))){
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
                            if(item.getStationId() != null){
                                preparedStatement.setInt(1, item.getStationId());
                            }else{
                                preparedStatement.setNull(1,Types.INTEGER);
                            }
                            if(item.getStation() != null) {
                                preparedStatement.setString(2, item.getStation());
                            }else{
                                preparedStatement.setNull(2,Types.VARCHAR);
                            }
                            if(item.getDate() != null){
                                preparedStatement.setDate(3, java.sql.Date.valueOf(item.getDate()));
                            }else{
                                preparedStatement.setNull(3,Types.DATE);
                            }
                            if(item.getHour() != null){
                                preparedStatement.setInt(4, item.getHour());
                            }else{
                                preparedStatement.setNull(4,Types.INTEGER);
                            }
                            if(item.getTemperature() != null){
                                preparedStatement.setDouble(5, item.getTemperature());
                            }else{
                                preparedStatement.setNull(5,Types.DOUBLE);
                            }
                            if(item.getWindSpeed() != null){
                                preparedStatement.setDouble(6, item.getWindSpeed());
                            }
                            else{
                                preparedStatement.setNull(6,Types.DOUBLE);
                            }
                            if(item.getWindDirection() != null){
                                preparedStatement.setDouble(7, item.getWindDirection());
                            }else{
                                preparedStatement.setNull(7,Types.DOUBLE);
                            }
                            if(item.getHumidity() != null){
                                preparedStatement.setDouble(8, item.getHumidity());
                            }else{
                                preparedStatement.setNull(8,Types.DOUBLE);
                            }
                            if(item.getRainFall() != null){
                                preparedStatement.setDouble(9, item.getRainFall());
                            }else{
                                preparedStatement.setNull(9,Types.DOUBLE);
                            }
                            if(item.getPressure() != null){
                                preparedStatement.setDouble(10, item.getPressure());
                            }else{
                                preparedStatement.setNull(10,Types.DOUBLE);
                            }
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
