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
                    data.setStationId(Integer.parseInt( jsonReader.nextString()));
                    break;
                case "stacja":
                    data.setStation(jsonReader.nextString());
                    break;
                case "data_pomiaru":
                    data.setDate(LocalDate.parse(jsonReader.nextString()));
                    break;
                case "godzina_pomiaru":
                    data.setHour(Integer.parseInt(jsonReader.nextString()));
                    break;
                case "temperatura":
                    data.setTemperature(Double.parseDouble(jsonReader.nextString()));
                    break;
                case "predkosc_wiatru":
                    data.setWindSpeed(Double.parseDouble(jsonReader.nextString()));
                    break;
                case "kierunek_wiatru":
                    data.setWindDirection(Double.parseDouble(jsonReader.nextString()));
                    break;
                case "wilgotnosc_wzgledna":
                    data.setHumidity(Double.parseDouble(jsonReader.nextString()));
                    break;
                case "suma_opadu":
                    data.setRainFall(Double.parseDouble(jsonReader.nextString()));
                    break;
                case "cisnienie":
                    if(jsonReader.peek() != JsonToken.NULL){
                        data.setPressure(Double.parseDouble(jsonReader.nextString()));
//                        System.out.println(jsonReader.NULL);
//                        System.out.println(JsonToken.NULL);
                    }else{
                        jsonReader.nextNull();
                        data.setPressure(0);
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
