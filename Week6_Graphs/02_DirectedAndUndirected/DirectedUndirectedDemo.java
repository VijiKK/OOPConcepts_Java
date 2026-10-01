import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Directed and undirected edges.
 *
 * A directed edge A -> B has a direction and does not automatically allow B -> A.
 * An undirected edge A -- B represents a two-way relationship.
 */
public class DirectedUndirectedDemo {

    // The map stores each vertex and the vertices reachable from it.
    private static final Map<String, Set<String>> directedGraph = new LinkedHashMap<>();
    private static final Map<String, Set<String>> undirectedGraph = new LinkedHashMap<>();

    static void addVertex(Map<String, Set<String>> graph, String vertex) {
        // Create an empty neighbor set only when the vertex is not already present.
        graph.putIfAbsent(vertex, new LinkedHashSet<>());
    }

    static void addDirectedEdge(String from, String to) {
        addVertex(directedGraph, from); // Ensure the starting vertex exists.
        addVertex(directedGraph, to);   // Ensure the ending vertex exists.
        directedGraph.get(from).add(to); // Store only the requested direction.
    }

    static void addUndirectedEdge(String first, String second) {
        addVertex(undirectedGraph, first);  // Ensure the first endpoint exists.
        addVertex(undirectedGraph, second); // Ensure the second endpoint exists.
        undirectedGraph.get(first).add(second); // Store first to second.
        undirectedGraph.get(second).add(first); // Also store second to first.
    }

    static boolean hasEdge(Map<String, Set<String>> graph, String from, String to) {
        // Check that from exists before asking whether its neighbor set contains to.
        return graph.containsKey(from) && graph.get(from).contains(to);
    }

    public static void main(String[] args) {
        addDirectedEdge("A", "B");   // A can reach B, but B cannot yet reach A.
        addUndirectedEdge("X", "Y"); // X and Y are connected in both directions.

        System.out.println("Directed A -> B: " + hasEdge(directedGraph, "A", "B"));
        System.out.println("Directed B -> A: " + hasEdge(directedGraph, "B", "A"));
        System.out.println("Undirected X -> Y: " + hasEdge(undirectedGraph, "X", "Y"));
        System.out.println("Undirected Y -> X: " + hasEdge(undirectedGraph, "Y", "X"));
    }
}
