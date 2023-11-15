package pl.dataViewer.client.data;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class StationData {

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Double getRainFall() {
        return rainFall;
    }

    public void setRainFall(double rainFall) {
        this.rainFall = rainFall;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @SerializedName("id_stacji")
    private Integer stationId;
    @SerializedName("stacja")
    private String station;
    @SerializedName("data_pomiaru")
    private LocalDate date;
    @SerializedName("godzina_pomiaru")
    private Integer hour;
    @SerializedName("temperatura")
    private Double temperature;
    @SerializedName("predkosc_wiatru")
    private Double windSpeed;
    @SerializedName("kierunek_wiatru")
    private Double windDirection;
    @SerializedName("wilgotnosc_wzgledna")
    private Double humidity;
    @SerializedName("suma_opadu")
    private Double rainFall;
    @SerializedName("cisnienie")
    private Double pressure;

    public StationData(Integer stationId, String station, LocalDate date, Integer hour, Double temperature, Double windSpeed, Double windDirection, Double humidity, Double rainFall, Double pressure) {
        this.stationId = stationId;
        this.station = station;
        this.date = date;
        this.hour = hour;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.humidity = humidity;
        this.rainFall = rainFall;
        this.pressure = pressure;
    }

    public StationData(){};


}
