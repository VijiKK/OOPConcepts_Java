import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Use DFS to find one path between two vertices.
 *
 * currentPath acts like the recursion stack. A vertex is added while going
 * deeper and removed while backtracking from a branch that does not reach the goal.
 */
public class DFSPathFindingDemo {

    private static final Map<String, List<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new ArrayList<>());
        graph.putIfAbsent(second, new ArrayList<>());
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    static boolean findPath(String current, String goal, Set<String> visited,
                            List<String> currentPath) {
        visited.add(current);    // Do not enter this vertex again through a cycle.
        currentPath.add(current);// Push the current vertex onto the path.

        if (current.equals(goal)) {
            return true; // Stop as soon as the target is reached.
        }

        for (String neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)
                    && findPath(neighbor, goal, visited, currentPath)) {
                return true; // Preserve the successful path during the returns.
            }
        }

        currentPath.remove(currentPath.size() - 1); // Backtrack from a failed branch.
        return false;
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("C", "F");

        List<String> path = new ArrayList<>();
        boolean found = findPath("A", "F", new LinkedHashSet<>(), path);

        System.out.println("Path found: " + found);
        System.out.println("One DFS path from A to F: " + path);
        System.out.println("DFS finds a path, but not necessarily the shortest path.");
    }
}
