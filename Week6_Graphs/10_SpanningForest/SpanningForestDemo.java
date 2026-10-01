import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Trees, forests, spanning trees, and spanning forests.
 *
 * A tree is connected and has no cycle. A forest is a collection of trees.
 * DFS discovery edges connect all reachable vertices without making a cycle;
 * across a disconnected graph, those edges form a spanning forest.
 */
public class SpanningForestDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static void buildTree(String vertex, Set<String> visited, List<String> treeEdges) {
        visited.add(vertex);

        for (String neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                treeEdges.add(vertex + "-" + neighbor); // Keep only the discovery edge.
                buildTree(neighbor, visited, treeEdges); // Continue in that subtree.
            }
        }
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "C"); // This extra edge makes a cycle in the original graph.
        addEdge("D", "E"); // D-E is a separate component.

        Set<String> visited = new LinkedHashSet<>();
        List<List<String>> forest = new ArrayList<>();

        for (String vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                List<String> oneTree = new ArrayList<>();
                buildTree(vertex, visited, oneTree);
                forest.add(oneTree);
            }
        }

        System.out.println("Spanning forest discovery edges: " + forest);
        System.out.println("Every original vertex was reached: " + (visited.size() == graph.size()));
        System.out.println("Number of trees/components: " + forest.size());
    }
}
