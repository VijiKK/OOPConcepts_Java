import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Subgraphs, spanning subgraphs, connectivity, and connected components.
 *
 * A subgraph uses vertices and edges selected from a larger graph. A spanning
 * subgraph contains every original vertex. A connected component is a maximal
 * group in which every vertex can reach every other vertex.
 */
public class SubgraphsAndConnectivityDemo {

    static void addVertex(Map<String, Set<String>> graph, String vertex) {
        graph.putIfAbsent(vertex, new LinkedHashSet<>());
    }

    static void addEdge(Map<String, Set<String>> graph, String first, String second) {
        addVertex(graph, first);
        addVertex(graph, second);
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static void collectComponent(String vertex, Map<String, Set<String>> graph,
                                 Set<String> visited, List<String> component) {
        visited.add(vertex);     // Mark this vertex so recursion will not revisit it.
        component.add(vertex);   // Record it as part of the current component.

        for (String neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                collectComponent(neighbor, graph, visited, component);
            }
        }
    }

    static List<List<String>> connectedComponents(Map<String, Set<String>> graph) {
        List<List<String>> components = new ArrayList<>();
        Set<String> visited = new LinkedHashSet<>();

        for (String vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                List<String> component = new ArrayList<>();
                collectComponent(vertex, graph, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> graph = new LinkedHashMap<>();
        addEdge(graph, "A", "B");
        addEdge(graph, "B", "C");
        addEdge(graph, "D", "E");
        addVertex(graph, "F"); // F is an isolated one-vertex component.

        Set<String> subgraphVertices = Set.of("A", "B", "C");
        boolean isSpanning = subgraphVertices.containsAll(graph.keySet());

        System.out.println("Subgraph vertices: " + subgraphVertices);
        System.out.println("Is it spanning? " + isSpanning);
        System.out.println("Connected components: " + connectedComponents(graph));
    }
}
