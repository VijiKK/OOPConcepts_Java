class Train {
    // Position is represented as a distance from one fixed point.
    private double distanceFromStation;

    void move(double distanceMoved) {
        // A positive distance moves away; a negative distance moves back.
        distanceFromStation = distanceFromStation + distanceMoved;
    }

    double getDistanceFromStation() {
        return distanceFromStation;
    }
}

public class PositionOnLineDemo {
    public static void main(String[] args) {
        Train train = new Train();
        train.move(12.5);
        train.move(2.5);

        System.out.println("Distance from station: "
                + train.getDistanceFromStation() + " miles");
    }
}

/* Expected output:
Distance from station: 15.0 miles
*/
