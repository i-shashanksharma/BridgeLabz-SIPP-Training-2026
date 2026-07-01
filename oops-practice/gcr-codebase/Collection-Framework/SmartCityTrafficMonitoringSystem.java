import java.util.*;
public class SmartCityTrafficMonitoringSystem {

    static HashMap<String, Integer> traffic = new HashMap<>();

    static void updateTraffic(String road, int vehicles) {
        traffic.put(road, traffic.getOrDefault(road, 0) + vehicles);
    }

    static void displaySortedRoads() {

        TreeMap<String, Integer> sorted = new TreeMap<>(traffic);

        System.out.println("Traffic Report:");

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void busiestRoad() {

        String road = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : traffic.entrySet()) {

            if (entry.getValue() > max) {
                max = entry.getValue();
                road = entry.getKey();
            }
        }

        System.out.println("Busiest Road: " + road);
        System.out.println("Vehicles: " + max);
    }

    public static void main(String[] args) {

        updateTraffic("Ring Road", 500);
        updateTraffic("Highway 1", 700);
        updateTraffic("Market Road", 300);
        updateTraffic("Ring Road", 200);

        displaySortedRoads();

        busiestRoad();

        System.out.println("Total Roads: " + traffic.size());
    }
}