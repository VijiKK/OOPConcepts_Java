import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Depth-First Search (DFS).
 *
 * DFS visits a vertex, goes as deep as possible through an unvisited neighbor,
 * and backtracks when it reaches a dead end. The base condition is implicit:
 * recursion occurs only for a neighbor that has not already been visited.
 */
public class DepthFirstSearchDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static void dfs(String vertex, Set<String> visited, List<String> order) {
        visited.add(vertex); // Mark before recursion to prevent an endless cycle.
        order.add(vertex);   // "Visit" means process the vertex; here we record it.

        for (String neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, order); // Explore the smaller neighbor subtree.
                // When that call ends, execution returns here and checks the next neighbor.
            }
        }
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("D", "E");
        addEdge("C", "F");

        Set<String> visited = new LinkedHashSet<>();
        List<String> order = new ArrayList<>();
        dfs("A", visited, order);

        System.out.println("DFS visit order: " + order);
        System.out.println("Expected classroom trace: A, B, D, E, C, F");
    }
}
