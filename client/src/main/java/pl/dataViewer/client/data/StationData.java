package pl.dataViewer.client.data;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class StationData {

    public int getStationId() {
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getRainFall() {
        return rainFall;
    }

    public void setRainFall(double rainFall) {
        this.rainFall = rainFall;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @SerializedName("id_stacji")
    private int stationId;
    @SerializedName("stacja")
    private String station;
    @SerializedName("data_pomiaru")
    private LocalDate date;
    @SerializedName("godzina_pomiaru")
    private int hour;
    @SerializedName("temperatura")
    private double temperature;
    @SerializedName("predkosc_wiatru")
    private double windSpeed;
    @SerializedName("kierunek_wiatru")
    private double windDirection;
    @SerializedName("wilgotnosc_wzgledna")
    private double humidity;
    @SerializedName("suma_opadu")
    private double rainFall;
    @SerializedName("cisnienie")
    private double pressure;

    public StationData(int stationId, String station, LocalDate date, int hour, double temperature, double windSpeed, double windDirection, double humidity, double rainFall, double pressure) {
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
