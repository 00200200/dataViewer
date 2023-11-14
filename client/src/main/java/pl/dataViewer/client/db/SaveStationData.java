package pl.dataViewer.client.db;
import pl.dataViewer.client.data.StationData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class SaveStationData {
    public void saveStationData(List<StationData> data){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataViewer","root","haslohaslo")){

            String sqlInsert = "INSERT INTO synop_data (id_stacji, nazwa_stacji, data_pomiaru, godzina_pomiaru, temperatura, predkosc_wiatru, kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String sqlCheckIfInDataBase = "SELECT id_stacji data_promiaru from synop_data where id_stacji=item.getStationId()";
            for(StationData item : data){
                try(PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)){
                    preparedStatement.setInt(1,item.getStationId());
                    preparedStatement.setString(2,item.getStation());
                    preparedStatement.setDate(3,java.sql.Date.valueOf(  item.getDate()));
                    preparedStatement.setInt(4,item.getHour());
                    preparedStatement.setDouble(5,item.getTemperature());
                    preparedStatement.setDouble(6,item.getWindSpeed());
                    preparedStatement.setDouble(7,item.getWindDirection());
                    preparedStatement.setDouble(8,item.getHumidity());
                    preparedStatement.setDouble(9,item.getRainFall());
                    preparedStatement.setDouble(10,item.getPressure());
                    preparedStatement.executeUpdate();
                    System.out.println("DODANO DANE");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
