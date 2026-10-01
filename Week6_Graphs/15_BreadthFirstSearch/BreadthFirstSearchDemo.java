import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * CONCEPT: Breadth-First Search (BFS) explores a graph level by level.
 *
 * A queue provides FIFO order: vertices discovered first are processed first.
 * Level 0 contains the start, level 1 its unvisited neighbors, and so on.
 */
public class BreadthFirstSearchDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static Map<String, Integer> bfs(String start, List<String> order) {
        Map<String, Integer> level = new LinkedHashMap<>(); // Vertex -> distance in edges.
        Queue<String> queue = new ArrayDeque<>();          // FIFO work list.

        level.put(start, 0); // Mark the start discovered at level zero.
        queue.add(start);    // Schedule the start for processing.

        while (!queue.isEmpty()) {
            String current = queue.remove(); // Remove the oldest scheduled vertex.
            order.add(current);               // Process it.

            for (String neighbor : graph.get(current)) {
                if (!level.containsKey(neighbor)) {
                    level.put(neighbor, level.get(current) + 1);
                    queue.add(neighbor); // Newly discovered vertices join the back.
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "E");
        addEdge("C", "F");

        List<String> order = new ArrayList<>();
        Map<String, Integer> levels = bfs("A", order);

        System.out.println("BFS order: " + order);
        System.out.println("Levels from A: " + levels);
        System.out.println("Level 0=[A], level 1=[B, C], level 2=[D, E, F]");
    }
}
