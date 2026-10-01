import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * CONCEPT: A small Graph ADT using generic Vertex<V> and Edge<E> objects.
 *
 * An ADT describes available operations without requiring users to know the
 * storage details. V is the vertex-element type; E is the edge-element type.
 */
public class GraphADTDemo {

    static class Vertex<V> {
        private final V element; // Store the user's value inside the vertex.

        Vertex(V element) {
            this.element = element;
        }

        V getElement() {
            return element;
        }

        @Override
        public String toString() {
            return String.valueOf(element);
        }
    }

    static class Edge<E, V> {
        private final E element;       // Information associated with the edge.
        private final Vertex<V> first; // First endpoint.
        private final Vertex<V> second;// Second endpoint.

        Edge(Vertex<V> first, Vertex<V> second, E element) {
            this.first = first;
            this.second = second;
            this.element = element;
        }
    }

    static class SimpleGraph<V, E> {
        // Each vertex maps to its incident edges: an adjacency-list representation.
        private final Map<Vertex<V>, List<Edge<E, V>>> adjacency = new LinkedHashMap<>();
        private final List<Edge<E, V>> edges = new ArrayList<>();

        Vertex<V> insertVertex(V element) {
            Vertex<V> vertex = new Vertex<>(element); // Wrap the element in a position.
            adjacency.put(vertex, new ArrayList<>());  // Begin with no incident edges.
            return vertex;                            // Give the new position to the caller.
        }

        Edge<E, V> insertEdge(Vertex<V> first, Vertex<V> second, E element) {
            Edge<E, V> edge = new Edge<>(first, second, element);
            edges.add(edge);                 // Store the edge in the graph-wide collection.
            adjacency.get(first).add(edge);  // The edge is incident on its first endpoint.
            adjacency.get(second).add(edge); // It is also incident on its second endpoint.
            return edge;
        }

        int numVertices() {
            return adjacency.size();
        }

        int numEdges() {
            return edges.size();
        }

        int degree(Vertex<V> vertex) {
            return adjacency.get(vertex).size();
        }

        Vertex<V> opposite(Vertex<V> vertex, Edge<E, V> edge) {
            // If vertex is the first endpoint, return the second; otherwise return first.
            return edge.first == vertex ? edge.second : edge.first;
        }
    }

    public static void main(String[] args) {
        SimpleGraph<String, Integer> graph = new SimpleGraph<>();
        Vertex<String> sea = graph.insertVertex("SEA");
        Vertex<String> sfo = graph.insertVertex("SFO");
        Vertex<String> lax = graph.insertVertex("LAX");

        Edge<Integer, String> seaToSfo = graph.insertEdge(sea, sfo, 679);
        graph.insertEdge(sfo, lax, 337);

        System.out.println("Vertices: " + graph.numVertices());
        System.out.println("Edges: " + graph.numEdges());
        System.out.println("Degree of SFO: " + graph.degree(sfo));
        System.out.println("Opposite SEA on its first edge: " + graph.opposite(sea, seaToSfo));
    }
}
