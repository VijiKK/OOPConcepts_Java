import java.util.Arrays;

/*
 * CONCEPT: Two useful properties of a simple undirected graph.
 *
 * 1. The sum of all vertex degrees equals 2m because every edge has two ends.
 * 2. A simple graph with n vertices has at most n(n-1)/2 edges.
 */
public class GraphPropertiesDemo {

    static int sum(int[] values) {
        int total = 0; // Accumulator begins at zero.
        for (int value : values) {
            total += value; // Add each vertex degree to the running total.
        }
        return total;
    }

    public static void main(String[] args) {
        int numberOfVertices = 4; // K4 has four vertices.
        int numberOfEdges = 6;    // Every pair of vertices is connected.
        int[] degrees = {3, 3, 3, 3}; // Each vertex is adjacent to the other three.

        int degreeSum = sum(degrees);
        int maximumEdges = numberOfVertices * (numberOfVertices - 1) / 2;

        System.out.println("Degrees: " + Arrays.toString(degrees));
        System.out.println("Sum of degrees: " + degreeSum);
        System.out.println("2m: " + (2 * numberOfEdges));
        System.out.println("Degree-sum property holds: " + (degreeSum == 2 * numberOfEdges));
        System.out.println("Maximum simple edges for n=4: " + maximumEdges);
    }
}
