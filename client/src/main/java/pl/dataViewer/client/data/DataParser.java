package pl.dataViewer.client.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.dataViewer.client.db.SaveStationData;

import java.util.Arrays;
import java.util.List;

public class DataParser {

    public List<StationData> parse(String jsonData) {
        Gson gson = new GsonBuilder().registerTypeAdapter(StationData.class, new StationDataAdapter()).create();
        StationData[] data = gson.fromJson(jsonData, StationData[].class);
        SaveStationData saveStationData = new SaveStationData();
        saveStationData.saveStationData(Arrays.asList(data));
        return Arrays.asList(data);
    }
}
