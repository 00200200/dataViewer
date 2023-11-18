package pl.dataViewer.client.data;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class StationDataAdapter extends TypeAdapter<StationData> {


    @Override
    public void write(JsonWriter jsonWriter, StationData stationData) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("id_stacji").value(stationData.getStationId());
        jsonWriter.name("stacja").value(stationData.getStation());
        jsonWriter.name("data_pomiaru").value(String.valueOf(stationData.getDate()));
        jsonWriter.name("godzina_pomiaru").value(stationData.getHour());
        jsonWriter.name("temperatura").value(stationData.getTemperature());
        jsonWriter.name("predkosc_wiatru").value(stationData.getWindSpeed());
        jsonWriter.name("kierunek_wiatru").value(stationData.getWindDirection());
        jsonWriter.name("wilgotnosc_wzgledna").value(stationData.getHumidity());
        jsonWriter.name("suma_opadu").value(stationData.getRainFall());
        jsonWriter.name("cisnienie").value(stationData.getPressure());
        jsonWriter.endObject();
    }

    @Override
    public StationData read(JsonReader jsonReader) throws IOException {
        StationData data = new StationData();
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String name = jsonReader.nextName();
            switch (name){
                case "id_stacji":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setStationId(Integer.parseInt(jsonReader.nextString()));
                    }
                    else{
                        jsonReader.nextNull();
                        data.setStationId(null);
                    }
                    break;
                case "stacja":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setStation(jsonReader.nextString());
                    }
                    else{
                        jsonReader.nextNull();
                        data.setStation(null);
                    }
                    break;
                case "data_pomiaru":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setDate(LocalDate.parse(jsonReader.nextString()));
                    }
                    else{
                        jsonReader.nextNull();
                        data.setDate(null);
                    }
                    break;
                case "godzina_pomiaru":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setHour(Integer.parseInt(jsonReader.nextString()));
                    }
                    else{
                        jsonReader.nextNull();
                        data.setHour(null);
                    }
                    break;
                case "temperatura":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setTemperature(Double.parseDouble(jsonReader.nextString()));
                    }
                    else{
                        jsonReader.nextNull();
                        data.setTemperature(null);
                    }
                    break;
                case "predkosc_wiatru":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setWindSpeed(Double.parseDouble(jsonReader.nextString()));
                    }
                    else{
                        jsonReader.nextNull();
                        data.setWindSpeed(null);
                    }
                    break;
                case "kierunek_wiatru":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setWindDirection(Double.parseDouble(jsonReader.nextString()));
                    }
                    else{
                        jsonReader.nextNull();
                        data.setWindDirection(null);
                    }
                    break;
                case "wilgotnosc_wzgledna":
                    if(jsonReader.peek() != JsonToken.NULL) {
                        data.setHumidity(Double.parseDouble(jsonReader.nextString()));
                    }
                 else{
                        jsonReader.nextNull();
                        data.setHumidity(null);
                    }
                    break;
                case "suma_opadu":
                    if(jsonReader.peek() != JsonToken.NULL){
                        data.setRainFall(Double.parseDouble(jsonReader.nextString()));

                    }else{
                        jsonReader.nextNull();
                        data.setRainFall(null);
                    }
                    break;
                case "cisnienie":
                    if(jsonReader.peek() != JsonToken.NULL){
                        data.setPressure(Double.parseDouble(jsonReader.nextString()));

                    }else{
                        jsonReader.nextNull();
                        data.setPressure(null);
                    }
                    break;
                default:
                    jsonReader.skipValue();

            }
        }
        jsonReader.endObject();
        return data;
    }
}
