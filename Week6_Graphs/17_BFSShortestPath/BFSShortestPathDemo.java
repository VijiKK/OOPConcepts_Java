import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * CONCEPT: BFS finds a shortest path by number of edges in an unweighted graph.
 *
 * The parent map remembers which vertex first discovered each new vertex. After
 * reaching the goal, following parent references backward reconstructs the route.
 */
public class BFSShortestPathDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static List<String> shortestPath(String start, String goal) {
        Queue<String> queue = new ArrayDeque<>();
        Map<String, String> parent = new LinkedHashMap<>();

        queue.add(start);
        parent.put(start, null); // null marks the beginning of the reconstructed path.

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.equals(goal)) {
                break; // BFS reaches the goal through a minimum-edge route.
            }

            for (String neighbor : graph.get(current)) {
                if (!parent.containsKey(neighbor)) {
                    parent.put(neighbor, current); // Record the discovery edge.
                    queue.add(neighbor);
                }
            }
        }

        if (!parent.containsKey(goal)) {
            return List.of(); // An empty list reports that no path exists.
        }

        List<String> path = new ArrayList<>();
        for (String at = goal; at != null; at = parent.get(at)) {
            path.add(at); // This initially builds goal-to-start order.
        }
        Collections.reverse(path); // Convert it to start-to-goal order.
        return path;
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("C", "E");
        addEdge("D", "F");
        addEdge("E", "D");

        List<String> path = shortestPath("A", "F");
        System.out.println("Minimum-edge path: " + path);
        System.out.println("Number of edges: " + (path.size() - 1));
        System.out.println("For weighted distance, use a weighted-path algorithm instead.");
    }
}
