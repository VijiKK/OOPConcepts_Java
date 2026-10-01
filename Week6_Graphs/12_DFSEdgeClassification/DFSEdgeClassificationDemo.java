import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: DFS discovery edges, back edges, and cycle detection.
 *
 * A discovery edge reaches an unvisited vertex and becomes part of the DFS tree.
 * An edge to an already visited vertex other than the parent is a back edge in
 * this undirected graph. That back edge proves that the graph contains a cycle.
 */
public class DFSEdgeClassificationDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();
    private static final Set<String> visited = new LinkedHashSet<>();
    private static final Set<String> processedEdges = new HashSet<>();
    private static final List<String> discoveryEdges = new ArrayList<>();
    private static final List<String> backEdges = new ArrayList<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static String edgeKey(String first, String second) {
        // Alphabetical normalization gives an undirected edge one shared key.
        return first.compareTo(second) < 0 ? first + "-" + second : second + "-" + first;
    }

    static void dfs(String vertex) {
        visited.add(vertex);

        for (String neighbor : graph.get(vertex)) {
            String key = edgeKey(vertex, neighbor);
            if (processedEdges.contains(key)) {
                continue; // Skip the second view of an undirected edge.
            }
            processedEdges.add(key);

            if (!visited.contains(neighbor)) {
                discoveryEdges.add(vertex + "-" + neighbor);
                dfs(neighbor);
            } else {
                backEdges.add(vertex + "-" + neighbor);
            }
        }
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("B", "D");
        addEdge("D", "E");
        addEdge("E", "B"); // This closes the B-D-E-B cycle.
        addEdge("A", "C");
        addEdge("C", "F");

        dfs("A");

        System.out.println("Discovery edges: " + discoveryEdges);
        System.out.println("Back edges: " + backEdges);
        System.out.println("Cycle exists: " + !backEdges.isEmpty());
    }
}
