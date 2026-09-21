import java.util.Arrays;

/*
 * CONCEPT: An array can store references to programmer-defined objects.
 *
 * This follows the deck's GameEntry and Scoreboard example. The Scoreboard
 * owns a GameEntry[] array, while each GameEntry stores one name and score.
 */

class GameEntry {
    private String name;
    private int score;

    public GameEntry(String playerName, int playerScore) {
        name = playerName;
        score = playerScore;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}

class Scoreboard {
    private GameEntry[] board;
    private int numEntries;

    public Scoreboard(int capacity) {
        // The array has capacity cells, all initially null.
        board = new GameEntry[capacity];
        numEntries = 0;
    }

    public void addAtEnd(GameEntry entry) {
        if (numEntries < board.length) {
            board[numEntries] = entry;
            numEntries++;
        }
    }

    public int size() {
        return numEntries;
    }

    @Override
    public String toString() {
        return Arrays.toString(board);
    }
}

public class ObjectArrayDemo {

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard(4);
        scoreboard.addAtEnd(new GameEntry("Alice", 950));
        scoreboard.addAtEnd(new GameEntry("Bob", 880));
        scoreboard.addAtEnd(new GameEntry("Eva", 820));

        System.out.println("Entries in use: " + scoreboard.size());
        System.out.println("Array cells: " + scoreboard);
    }
}

/*
Expected output:
Entries in use: 3
Array cells: [(Alice, 950), (Bob, 880), (Eva, 820), null]
*/
