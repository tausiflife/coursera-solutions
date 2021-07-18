package com.general.ood.objectvilla.subway;

import java.util.*;

public class Subway {
    private Set<Station> stations;
    private List<Connection> connections;
    private Map<Station, List<Station>> network;

    public Subway() {
        stations = new HashSet<>();
        connections = new ArrayList<>();
        network = new HashMap<>();
    }

    public void addStation(String stationName) {
        stations.add(new Station(stationName));
    }

    public boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }

    public void addConnection(String station1Name, String station2Name, String lineName) {
        if (hasStation(station1Name) && hasStation(station2Name)) {
            Station station1 = new Station(station1Name);
            Station station2 = new Station(station2Name);
            connections.add(new Connection(station1, station2, lineName));
            addToNetwork(station1, station2);
            addToNetwork(station2, station1);
        } else if (!hasStation(station1Name))
            throw new NoSuchElementException("No station with station name : " + station1Name + " exists.");
        else
            throw new NoSuchElementException("No station with station name : " + station2Name + " exists.");
    }

    private void addToNetwork(Station station1, Station station2) {
        network.computeIfPresent(station1, (station, list)-> { list.add(station2); return list; });
        network.computeIfAbsent(station1, (station) ->  {
            List<Station> stations = new ArrayList<>();
            stations.add(station2);
            return stations;
        });
    }

    public boolean hasConnection(String station1Name, String station2Name, String lineName) {
        Station station1 = new Station(station1Name);
        Station station2 = new Station(station2Name);
        return connections.stream().anyMatch(conn -> conn.getLineName().equals(lineName)
                && conn.getStation1().equals(station1) && conn.getStation2().equals(station2));
    }

    public List<Connection> getDirections(String source, String destination) {
        if (!hasStation(source) || !hasStation(destination))
            throw new RuntimeException("Stations entered do not exist on the subway");
        return null;
    }
}
