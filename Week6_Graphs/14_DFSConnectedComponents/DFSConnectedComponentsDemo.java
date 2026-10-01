import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Repeated DFS finds every connected component.
 *
 * One DFS call reaches only the component containing its start vertex. The outer
 * loop starts another DFS whenever it encounters an unvisited vertex.
 */
public class DFSConnectedComponentsDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addVertex(String vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    static void addEdge(String first, String second) {
        addVertex(first);
        addVertex(second);
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static void dfs(String vertex, Set<String> visited, List<String> component) {
        visited.add(vertex);
        component.add(vertex);

        for (String neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("B", "C");
        addEdge("D", "E");
        addVertex("F"); // An isolated vertex is a component by itself.

        Set<String> visited = new LinkedHashSet<>();
        List<List<String>> components = new ArrayList<>();

        for (String vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                List<String> component = new ArrayList<>();
                dfs(vertex, visited, component);
                components.add(component);
            }
        }

        System.out.println("Components: " + components);
        System.out.println("Number of components: " + components.size());
    }
}
