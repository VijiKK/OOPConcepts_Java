import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * CONCEPT: Edge-list, adjacency-list, and adjacency-matrix representations.
 *
 * All three structures below represent the same undirected graph. The visible
 * graph is unchanged; only the way its edges are stored in memory changes.
 */
public class GraphRepresentationsDemo {

    static class Edge {
        final String first;  // One endpoint stored in the edge object.
        final String second; // The other endpoint stored in the edge object.

        Edge(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + "-" + second;
        }
    }

    public static void main(String[] args) {
        List<String> vertices = List.of("A", "B", "C");

        // EDGE LIST: Store one object for each edge.
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge("A", "B"));
        edgeList.add(new Edge("A", "C"));
        edgeList.add(new Edge("B", "C"));

        // ADJACENCY LIST: Each vertex stores a collection of its neighbors.
        Map<String, Set<String>> adjacencyList = new LinkedHashMap<>();
        for (String vertex : vertices) {
            adjacencyList.put(vertex, new LinkedHashSet<>());
        }
        for (Edge edge : edgeList) {
            adjacencyList.get(edge.first).add(edge.second);
            adjacencyList.get(edge.second).add(edge.first);
        }

        // ADJACENCY MATRIX: matrix[i][j] tells whether vertices i and j are adjacent.
        boolean[][] matrix = new boolean[vertices.size()][vertices.size()];
        for (Edge edge : edgeList) {
            int firstIndex = vertices.indexOf(edge.first);
            int secondIndex = vertices.indexOf(edge.second);
            matrix[firstIndex][secondIndex] = true;
            matrix[secondIndex][firstIndex] = true;
        }

        System.out.println("Edge list: " + edgeList);
        System.out.println("Adjacency list: " + adjacencyList);
        System.out.println("Matrix says A-B exists: " + matrix[0][1]);
    }
}
