class GridRobot {
    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    private int row;
    private int column;
    private int direction;

    GridRobot(int startingRow, int startingColumn, int startingDirection) {
        row = startingRow;
        column = startingColumn;
        direction = startingDirection;
    }

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

    void turnLeft() {
        // Adding 3 and taking remainder 4 turns EAST (1) into NORTH (0).
        direction = (direction + 3) % 4;
    }

    void displayPosition() {
        System.out.println("Position: (" + row + ", " + column + ")");
    }
}

public class GridPositionDemo {
    public static void main(String[] args) {
        // Begin at the position used in the classroom question, facing East.
        GridRobot robot = new GridRobot(2, 2, GridRobot.EAST);
        System.out.print("Starting ");
        robot.displayPosition();

        // Moving East increases only the column: (2, 2) becomes (2, 3).
        robot.moveOneUnit();
        System.out.print("After moving East ");
        robot.displayPosition();

        // Turn from East to North; moving North decreases only the row.
        robot.turnLeft();
        robot.moveOneUnit();
        System.out.print("After moving North ");
        robot.displayPosition();
    }
}

/* Expected output:
Starting Position: (2, 2)
After moving East Position: (2, 3)
After moving North Position: (1, 3)
*/
