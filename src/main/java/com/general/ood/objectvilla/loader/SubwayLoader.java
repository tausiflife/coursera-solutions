package com.general.ood.objectvilla.loader;

import com.general.ood.objectvilla.subway.Subway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SubwayLoader {
    private Subway subway;

    public SubwayLoader() {
        this.subway = new Subway();
    }

    public Subway loadFromFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        loadStations(bufferedReader);
        String lineName = bufferedReader.readLine();
        while (lineName != null && !lineName.isEmpty()) {
            loadLine(bufferedReader, lineName);
            lineName = bufferedReader.readLine();
        }
        return subway;
    }

    private void loadLine(BufferedReader bufferedReader, String lineName) throws IOException {
        String stationName1 = bufferedReader.readLine();
        String stationName2 = bufferedReader.readLine();
        while (stationName2 != null && !stationName2.isEmpty()) {
            subway.addConnection(stationName1, stationName2, lineName);
            stationName1 = stationName2;
            stationName2 = bufferedReader.readLine();
        }
    }

    private void loadStations(BufferedReader bufferedReader) throws IOException {
        String currentLine = bufferedReader.readLine();
        while (!currentLine.isEmpty()) {
            subway.addStation(currentLine);
            currentLine = bufferedReader.readLine();
        }
    }
}
