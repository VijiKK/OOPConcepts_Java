class GridRobot {
    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    private int row;
    private int column;
    private int direction = EAST;

    void moveOneUnit() {
        // Only one coordinate changes, based on the current direction.
        if (direction == NORTH) {
            row--;
        } else if (direction == EAST) {
            column++;
        } else if (direction == SOUTH) {
            row++;
        } else if (direction == WEST) {
            column--;
        }
    }

    void turnRight() {
        // Modulo returns to NORTH after WEST: (3 + 1) % 4 is 0.
        direction = (direction + 1) % 4;
    }

    void displayPosition() {
        System.out.println("Position: (" + row + ", " + column + ")");
    }
}

public class GridPositionDemo {
    public static void main(String[] args) {
        GridRobot robot = new GridRobot();
        robot.moveOneUnit();
        robot.turnRight();
        robot.moveOneUnit();
        robot.displayPosition();
    }
}

/* Expected output:
Position: (1, 1)
*/
