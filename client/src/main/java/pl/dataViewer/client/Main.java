package pl.dataViewer.client;

import pl.dataViewer.client.api.ImgwApiClient;
import pl.dataViewer.client.data.DataParser;
import pl.dataViewer.client.data.StationData;
import pl.dataViewer.client.db.SaveStationData;


import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        ImgwApiClient apiClient = new ImgwApiClient();
        DataParser parser = new DataParser();
        CompletableFuture<String> data = apiClient.getDataFromApi();
        data.thenAccept(jsonData -> {
            String[] newData =  jsonData.split("},");
            List<StationData> stationDataList = parser.parse(jsonData);
        }).exceptionally(ex -> {
            System.out.println("BŁĄD" + ex.getMessage());
            return null;
        });
        data.join();
        SaveStationData saveStationData = new SaveStationData();
    }
}
