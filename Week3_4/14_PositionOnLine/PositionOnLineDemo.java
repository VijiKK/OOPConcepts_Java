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
        // Starting from 0.0, moving 5.0 increases the stored position to 5.0.
        train.move(5.0);
        System.out.println("After moving forward: "
                + train.getDistanceFromStation() + " miles");

        // A negative distance changes the same field in the opposite direction.
        train.move(-2.0);
        System.out.println("After moving back: "
                + train.getDistanceFromStation() + " miles");
    }
}

/* Expected output:
After moving forward: 5.0 miles
After moving back: 3.0 miles
*/
