import java.util.ArrayList;
import java.util.List;

/*
 * CONCEPT: A graph G = (V, E) stores vertices and edges.
 *
 * This airport example models airports as vertices and direct routes as edges.
 * An edge may also carry extra information, such as the distance in miles.
 */
public class GraphBasicsDemo {

    // A vertex represents one item in the graph.
    static class Airport {
        private final String code; // The airport code is the vertex's element.

        Airport(String code) {
            this.code = code; // Save the value supplied by the caller.
        }

        String getCode() {
            return code; // Return the data stored in this vertex.
        }
    }

    // An edge connects two vertices and can store an additional value.
    static class Route {
        private final Airport from; // First endpoint of the route.
        private final Airport to;   // Second endpoint of the route.
        private final int miles;    // Element stored with the edge.

        Route(Airport from, Airport to, int miles) {
            this.from = from;   // Remember the starting endpoint.
            this.to = to;       // Remember the ending endpoint.
            this.miles = miles; // Remember the route distance.
        }

        void display() {
            // Print both endpoints and the information stored on the edge.
            System.out.println(from.getCode() + " -- " + miles + " miles -- " + to.getCode());
        }
    }

    public static void main(String[] args) {
        // Create three separate vertex objects.
        Airport sea = new Airport("SEA");
        Airport sfo = new Airport("SFO");
        Airport lax = new Airport("LAX");

        // V is the collection of vertices in G = (V, E).
        List<Airport> vertices = new ArrayList<>();
        vertices.add(sea);
        vertices.add(sfo);
        vertices.add(lax);

        // E is the collection of edges in G = (V, E).
        List<Route> edges = new ArrayList<>();
        edges.add(new Route(sea, sfo, 679));
        edges.add(new Route(sfo, lax, 337));
        edges.add(new Route(sea, lax, 954));

        System.out.println("Number of vertices: " + vertices.size());
        System.out.println("Number of edges: " + edges.size());
        System.out.println("Direct routes:");

        // Visit every edge so that students can see the graph's connections.
        for (Route route : edges) {
            route.display();
        }
    }
}

/*
Expected output:
Number of vertices: 3
Number of edges: 3
Direct routes:
SEA -- 679 miles -- SFO
SFO -- 337 miles -- LAX
SEA -- 954 miles -- LAX
*/
