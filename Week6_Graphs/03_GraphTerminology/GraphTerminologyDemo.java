import java.util.ArrayList;
import java.util.List;

/*
 * CONCEPT: Endpoints, incidence, adjacency, degree, parallel edges, and self-loops.
 *
 * This example deliberately uses an edge list because it lets us inspect every edge.
 * In an undirected graph, a self-loop contributes two to the degree of its vertex.
 */
public class GraphTerminologyDemo {

    static class Edge {
        final String name;   // A label lets us distinguish parallel edges.
        final String first;  // One endpoint.
        final String second; // The other endpoint.

        Edge(String name, String first, String second) {
            this.name = name;
            this.first = first;
            this.second = second;
        }

        boolean isIncidentOn(String vertex) {
            // An edge is incident on a vertex when that vertex is an endpoint.
            return first.equals(vertex) || second.equals(vertex);
        }

        boolean isSelfLoop() {
            return first.equals(second); // Both endpoints are the same vertex.
        }
    }

    static int degree(List<Edge> edges, String vertex) {
        int degree = 0; // Start with no incident edge ends counted.

        for (Edge edge : edges) {
            if (edge.first.equals(vertex)) {
                degree++; // Count the first endpoint when it matches.
            }
            if (edge.second.equals(vertex)) {
                degree++; // Count the second endpoint; a loop therefore counts twice.
            }
        }
        return degree;
    }

    static boolean areAdjacent(List<Edge> edges, String first, String second) {
        for (Edge edge : edges) {
            // Either endpoint order represents adjacency in an undirected graph.
            boolean forward = edge.first.equals(first) && edge.second.equals(second);
            boolean reverse = edge.first.equals(second) && edge.second.equals(first);
            if (forward || reverse) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge("a", "U", "V"));
        edges.add(new Edge("b", "V", "X"));
        edges.add(new Edge("h", "X", "Z"));
        edges.add(new Edge("i", "X", "Z")); // h and i are parallel edges.
        edges.add(new Edge("j", "X", "X")); // j is a self-loop.

        System.out.println("Endpoints of edge a: U and V");
        System.out.println("U and V are adjacent: " + areAdjacent(edges, "U", "V"));
        System.out.println("Degree of X: " + degree(edges, "X"));
        System.out.println("h and i are parallel: true");
        System.out.println("j is a self-loop: " + edges.get(4).isSelfLoop());
    }
}
