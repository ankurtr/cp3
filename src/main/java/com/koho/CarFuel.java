package com.koho;

import java.util.Optional;

public class CarFuel {
    int maxWait = 0;

    static class Station {
        public String name;
        public int capacity;
        public int waitTime;

        public Station(String name, int cap, int waitTime) {
            this.name = name;
            this.capacity = cap;
            this.waitTime = waitTime;
        }

        private boolean canUse(int fuelRequired) {
            return this.capacity >= fuelRequired;
        }

        private boolean isAvailable() {
            return this.waitTime == 0;
        }

    }

    public int solution(int[] A, int x, int y, int z) {
        Station X = new Station("X", x, 0);
        Station Y = new Station("Y", y, 0);
        Station Z = new Station("Z", z, 0);

        Station[] stations = {X, Y, Z};
        int i = 0;
        while (i < A.length) {
            int car = A[i];
            Optional<Station> station = getStation(stations, car);
            if (station.isPresent()) {
                if (station.get().isAvailable()) {
                    station.get().waitTime += car;
                } else {
                    maxWait += station.get().waitTime;
                    int reduceTime = station.get().waitTime;
                    for (int j = 0; j < stations.length; j++) {
                        if (stations[j].waitTime >= station.get().waitTime) {
                            stations[j].waitTime -= reduceTime;
                        } else {
                            stations[j].waitTime = 0;
                        }
                    }
                    station.get().waitTime = car;
                }
                station.get().capacity -= car;
                i++;
            } else {
                return -1;
            }
        }
        return maxWait;
    }

    private Optional<Station> getStation(Station[] stations, int capacity) {

        int minWait = Integer.MAX_VALUE;
        Optional<Station> station = Optional.empty();
        for (int i = 0; i < stations.length; i++) {
            if (stations[i].canUse(capacity)) {
                if (stations[i].isAvailable()) {
                    return Optional.of(stations[i]);
                } else {
                    if (stations[i].waitTime < minWait) {
                        minWait = stations[i].waitTime;
                        station = Optional.of(stations[i]);
                    }
                }
            }
        }
        return station;
    }
}
