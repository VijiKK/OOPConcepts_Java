import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * CONCEPT: Representation choice changes the cost of graph operations.
 *
 * This small experiment counts inspected entries when searching for edge A-E.
 * It illustrates the idea behind the asymptotic performance table in the slides.
 */
public class RepresentationPerformanceDemo {

    static class Edge {
        final String first;
        final String second;

        Edge(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    static int edgeListChecks(List<Edge> edges, String first, String second) {
        int checks = 0;
        for (Edge edge : edges) {
            checks++; // One more edge record has been inspected.
            boolean matches = edge.first.equals(first) && edge.second.equals(second);
            boolean reverse = edge.first.equals(second) && edge.second.equals(first);
            if (matches || reverse) {
                return checks;
            }
        }
        return checks;
    }

    static int adjacencyListChecks(Map<String, List<String>> graph, String first, String second) {
        int checks = 0;
        for (String neighbor : graph.get(first)) {
            checks++; // Inspect only neighbors of first, not every graph edge.
            if (neighbor.equals(second)) {
                return checks;
            }
        }
        return checks;
    }

    public static void main(String[] args) {
        List<Edge> edges = List.of(
                new Edge("A", "B"), new Edge("B", "C"),
                new Edge("C", "D"), new Edge("A", "E"));

        Map<String, List<String>> adjacency = new LinkedHashMap<>();
        adjacency.put("A", new ArrayList<>(List.of("B", "E")));

        boolean[][] matrix = new boolean[5][5];
        matrix[0][4] = true; // A is index 0 and E is index 4.

        System.out.println("Edge-list entries checked: " + edgeListChecks(edges, "A", "E"));
        System.out.println("A's neighbor entries checked: " + adjacencyListChecks(adjacency, "A", "E"));
        System.out.println("Matrix cell checks: 1, found = " + matrix[0][4]);
        System.out.println("Matrix tradeoff: fast lookup but O(n^2) storage.");
    }
}
