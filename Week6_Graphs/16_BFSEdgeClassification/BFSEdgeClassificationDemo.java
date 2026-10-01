import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * CONCEPT: BFS discovery edges and cross edges.
 *
 * A discovery edge first reaches a vertex and belongs to the BFS tree. An edge
 * whose endpoint was already discovered is a cross edge in this undirected graph.
 */
public class BFSEdgeClassificationDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static String edgeKey(String first, String second) {
        return first.compareTo(second) < 0 ? first + "-" + second : second + "-" + first;
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "E"); // This will become a cross edge.
        addEdge("C", "F");

        Queue<String> queue = new ArrayDeque<>();
        Set<String> discovered = new LinkedHashSet<>();
        Set<String> processedEdges = new HashSet<>();
        List<String> discoveryEdges = new ArrayList<>();
        List<String> crossEdges = new ArrayList<>();

        discovered.add("A");
        queue.add("A");

        while (!queue.isEmpty()) {
            String current = queue.remove();

            for (String neighbor : graph.get(current)) {
                String key = edgeKey(current, neighbor);
                if (processedEdges.contains(key)) {
                    continue; // An undirected edge appears in two adjacency lists.
                }
                processedEdges.add(key);

                if (discovered.add(neighbor)) {
                    discoveryEdges.add(current + "-" + neighbor);
                    queue.add(neighbor);
                } else {
                    crossEdges.add(current + "-" + neighbor);
                }
            }
        }

        System.out.println("Discovery edges: " + discoveryEdges);
        System.out.println("Cross edges: " + crossEdges);
    }
}
