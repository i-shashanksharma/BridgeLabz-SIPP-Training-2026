import java.util.*;

public class NetworkConnectivity {

    static void dfsMark(Map<Integer, List<Integer>> network,
                        int node,
                        Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : network.getOrDefault(node, Collections.emptyList())) {

            if (!visited.contains(neighbor))
                dfsMark(network, neighbor, visited);
        }
    }

    static int countNetworkSegments(Map<Integer, List<Integer>> network,
                                    int n) {

        Set<Integer> visited = new HashSet<>();

        int segments = 0;

        for (int server = 0; server < n; server++) {

            if (!visited.contains(server)) {
                segments++;
                dfsMark(network, server, visited);
            }
        }

        return segments;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> network = new HashMap<>();

        network.put(0, Arrays.asList(1));
        network.put(1, Arrays.asList(0, 2));
        network.put(2, Arrays.asList(1));

        network.put(3, Arrays.asList(4));
        network.put(4, Arrays.asList(3));

        int components = countNetworkSegments(network, 5);

        System.out.println("Connected Components = " + components);

        if (components == 1)
            System.out.println("Fully Connected");
        else
            System.out.println("Not Fully Connected");
    }
}
