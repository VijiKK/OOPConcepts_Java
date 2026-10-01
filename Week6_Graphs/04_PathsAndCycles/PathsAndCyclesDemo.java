import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Walks, paths, simple paths, cycles, and simple cycles.
 *
 * A valid path follows existing edges. A simple path does not repeat vertices.
 * A cycle begins and ends at the same vertex. A simple cycle repeats only that
 * starting/ending vertex.
 */
public class PathsAndCyclesDemo {

    private static final Map<String, Set<String>> graph = new LinkedHashMap<>();

    static void addEdge(String first, String second) {
        graph.putIfAbsent(first, new LinkedHashSet<>());
        graph.putIfAbsent(second, new LinkedHashSet<>());
        graph.get(first).add(second);  // Undirected connection in one direction.
        graph.get(second).add(first);  // Undirected connection in the other direction.
    }

    static boolean followsEdges(List<String> walk) {
        // Compare every consecutive pair in the proposed walk.
        for (int i = 0; i < walk.size() - 1; i++) {
            String current = walk.get(i);
            String next = walk.get(i + 1);
            if (!graph.getOrDefault(current, Set.of()).contains(next)) {
                return false; // One missing edge makes the entire walk invalid.
            }
        }
        return true;
    }

    static boolean isSimplePath(List<String> path) {
        // A set removes duplicates, so equal sizes mean no vertex was repeated.
        return followsEdges(path) && new HashSet<>(path).size() == path.size();
    }

    static boolean isSimpleCycle(List<String> cycle) {
        if (cycle.size() < 4 || !followsEdges(cycle)) {
            return false; // Require at least three vertices plus the repeated start.
        }
        if (!cycle.get(0).equals(cycle.get(cycle.size() - 1))) {
            return false; // A cycle must return to its starting vertex.
        }

        // Exclude the final repeated start before checking interior uniqueness.
        List<String> withoutRepeatedEnd = cycle.subList(0, cycle.size() - 1);
        return new HashSet<>(withoutRepeatedEnd).size() == withoutRepeatedEnd.size();
    }

    public static void main(String[] args) {
        addEdge("A", "B");
        addEdge("B", "D");
        addEdge("D", "C");
        addEdge("C", "A");

        List<String> path = Arrays.asList("A", "B", "D");
        List<String> cycle = Arrays.asList("A", "B", "D", "C", "A");
        List<String> repeated = Arrays.asList("A", "B", "A", "C");

        System.out.println(path + " is a simple path: " + isSimplePath(path));
        System.out.println(cycle + " is a simple cycle: " + isSimpleCycle(cycle));
        System.out.println(repeated + " is a simple path: " + isSimplePath(repeated));
    }
}
