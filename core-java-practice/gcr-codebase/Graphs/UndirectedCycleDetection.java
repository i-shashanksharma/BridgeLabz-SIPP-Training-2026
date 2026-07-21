import java.util.*;

public class UndirectedCycleDetection {

    static boolean dfsCycleCheck(
            Map<Integer, List<Integer>> graph,
            int node,
            int parent,
            Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {

            if (!visited.contains(neighbor)) {

                if (dfsCycleCheck(graph, neighbor, node, visited))
                    return true;

            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    static boolean hasWiringLoop(
            Map<Integer, List<Integer>> graph,
            int n) {

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {

            if (!visited.contains(i)) {

                if (dfsCycleCheck(graph, i, -1, visited))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2));
        graph.put(2, Arrays.asList(0, 1));

        System.out.println(hasWiringLoop(graph, 3));
    }
}
