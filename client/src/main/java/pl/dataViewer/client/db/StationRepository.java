package pl.dataViewer.client.db;

import pl.dataViewer.client.data.StationData;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;


public class StationRepository {

    public List<String> getAllStationNames() {
        List<String> stationNames = new ArrayList<>();
        String query = "SELECT DISTINCT nazwa_stacji FROM synop_data";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataViewer", "root", "haslohaslo")) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stationNames.add(resultSet.getString("nazwa_stacji"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stationNames;

    }

    public List<StationData> getAllCheckedStations(String stationName,boolean stationId, boolean station, boolean date, boolean hour, boolean temperature, boolean windSpeed, boolean windDirection,
                                                   boolean humidity, boolean rainFall, boolean pressure) {
        List<StationData> checkedData = new ArrayList<>();
        String query = "SELECT ";
        boolean firstColumn = true;
        if (stationId) {
            query += "id_stacji";
            firstColumn = false;
        }
        if (station) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "nazwa_stacji";
            firstColumn = false;
        }
        if (date) {
            if (!firstColumn) {
               query += ", ";
            }
            query += "data_pomiaru";
            firstColumn = false;
        }
        if (hour) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "godzina_pomiaru";
            firstColumn = false;
        }
        if (temperature) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "temperatura";
            firstColumn = false;
        }
        if (windSpeed) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "predkosc_wiatru";
            firstColumn = false;
        }
        if (windDirection) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "kierunek_wiatru";
            firstColumn = false;
        }
        if (humidity) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "wilgotnosc_wzgledna";
            firstColumn = false;
        }
        if (rainFall) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "suma_opadu";
            firstColumn = false;
        }
        if (pressure) {
            if (!firstColumn) {
                query += ", ";
            }
            query += "cisnienie";
            firstColumn = false;
        }
        if(query == "SELECT "){
            return null;
        }
        query += " FROM synop_data WHERE nazwa_stacji = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataViewer","root","haslohaslo")){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,stationName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                StationData data = new StationData();
                if(stationId){
                    data.setStationId(resultSet.getInt("id_stacji"));
                    if(resultSet.wasNull()){
                        data.setStationId(null);
                    }
                }
                if(station){
                    data.setStation(resultSet.getString("nazwa_stacji"));
                    if(resultSet.wasNull()){
                        data.setStation(null);
                    }
                }
                if(date){
                    data.setDate(resultSet.getDate("data_pomiaru").toLocalDate());
                    if(resultSet.wasNull()){
                        data.setDate(null);
                    }
                }
                if(hour){
                    data.setHour(resultSet.getInt("godzina_pomiaru"));
                    if(resultSet.wasNull()){
                        data.setHour(null);
                    }
                }
                if(temperature){
                    data.setTemperature(resultSet.getDouble("temperatura"));
                    if(resultSet.wasNull()){
                        data.setTemperature(null);
                    }
                }
                if(windSpeed){
                    data.setWindSpeed(resultSet.getDouble("predkosc_wiatru"));
                    if(resultSet.wasNull()){
                        data.setWindSpeed(null);
                    }
                }
                if(windDirection){
                    data.setWindDirection(resultSet.getDouble("kierunek_wiatru"));
                    if(resultSet.wasNull()){
                        data.setWindDirection(null);
                    }
                }
                if(humidity){
                    data.setHumidity(resultSet.getDouble("wilgotnosc_wzgledna"));
                    if(resultSet.wasNull()){
                        data.setHumidity(null);
                    }
                }
                if(rainFall){
                    data.setRainFall(resultSet.getDouble("suma_opadu"));
                    if(resultSet.wasNull()){
                        data.setRainFall(null);
                    }
                }
                if(pressure) {
                    data.setPressure(resultSet.getDouble("cisnienie"));
                    if(resultSet.wasNull()){
                        data.setPressure(null);
                    }
                }
                checkedData.add(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return checkedData;
    }
}
