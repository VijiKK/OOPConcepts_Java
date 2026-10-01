import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * CONCEPT: Compare DFS and BFS on exactly the same graph.
 *
 * DFS uses recursion here and follows one branch deeply. BFS uses a queue and
 * explores by levels. With adjacency lists, both run in O(n + m) time.
 */
public class DFSvsBFSDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static void dfs(String vertex, Set<String> visited, List<String> order) {
        visited.add(vertex);
        order.add(vertex);
        for (String neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, order);
            }
        }
    }

    static List<String> bfs(String start) {
        List<String> order = new ArrayList<>();
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            order.add(current);
            for (String neighbor : graph.get(current)) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "F");

        List<String> dfsOrder = new ArrayList<>();
        dfs("A", new LinkedHashSet<>(), dfsOrder);

        System.out.println("DFS (deep first):  " + dfsOrder);
        System.out.println("BFS (level first): " + bfs("A"));
        System.out.println("Use BFS for minimum-edge paths in unweighted graphs.");
        System.out.println("Use DFS for backtracking, cycle work, and deep exploration.");
    }
}
