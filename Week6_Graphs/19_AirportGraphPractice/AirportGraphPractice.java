import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * COMBINED PRACTICE: A weighted airport graph with a BFS minimum-stop search.
 *
 * The graph stores mileage on each route, but BFS ignores those weights. Therefore,
 * the returned route minimizes the number of flight edges, not the total miles.
 */
public class AirportGraphPractice {

    static class Route {
        final String destination; // Neighboring airport reached by this edge.
        final int miles;          // Weight carried by the edge.

        Route(String destination, int miles) {
            this.destination = destination;
            this.miles = miles;
        }
    }

    private static final Map<String, List<Route>> graph = new LinkedHashMap<>();

    static void addAirport(String code) {
        graph.putIfAbsent(code, new ArrayList<>());
    }

    static void addRoute(String first, String second, int miles) {
        addAirport(first);
        addAirport(second);
        graph.get(first).add(new Route(second, miles));
        graph.get(second).add(new Route(first, miles));
    }

    static List<String> minimumFlights(String start, String goal) {
        Queue<String> queue = new ArrayDeque<>();
        Map<String, String> parent = new LinkedHashMap<>();
        queue.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.equals(goal)) {
                break;
            }
            for (Route route : graph.get(current)) {
                if (!parent.containsKey(route.destination)) {
                    parent.put(route.destination, current);
                    queue.add(route.destination);
                }
            }
        }

        if (!parent.containsKey(goal)) {
            return List.of();
        }

        List<String> path = new ArrayList<>();
        for (String airport = goal; airport != null; airport = parent.get(airport)) {
            path.add(airport);
        }
        Collections.reverse(path);
        return path;
    }

    static int milesForPath(List<String> path) {
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String from = path.get(i);
            String to = path.get(i + 1);
            for (Route route : graph.get(from)) {
                if (route.destination.equals(to)) {
                    total += route.miles;
                    break;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        addRoute("SFO", "LAX", 337);
        addRoute("LAX", "DFW", 1235);
        addRoute("DFW", "PVD", 1528);
        addRoute("SFO", "ORD", 1843);
        addRoute("ORD", "PVD", 849);

        List<String> route = minimumFlights("SFO", "PVD");
        System.out.println("Minimum-flight route: " + route);
        System.out.println("Flights required: " + (route.size() - 1));
        System.out.println("Miles along that route: " + milesForPath(route));
        System.out.println("Reminder: minimum flights does not always mean minimum miles.");
    }
}
