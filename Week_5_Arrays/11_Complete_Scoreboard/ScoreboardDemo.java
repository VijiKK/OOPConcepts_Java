import java.util.Arrays;

/*
 * CONCEPT: Complete GameEntry and Scoreboard example from the array slides.
 *
 * The board remains ordered from highest score to lowest score. Inserting a
 * qualifying score shifts lower scores right. Removing an entry shifts later
 * scores left. Both middle operations have O(n) worst-case running time.
 */

class GameEntry {
    private String name;
    private int score;

    public GameEntry(String playerName, int playerScore) {
        name = playerName;
        score = playerScore;
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
    private int numEntries;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
        numEntries = 0;
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();

        /*
         * Accept the score if space remains, or if it is better than the
         * current lowest score. The || operator short-circuits, so Java does
         * not read board[-1] when numEntries is initially zero.
         */
        if (numEntries < board.length
                || newScore > board[numEntries - 1].getScore()) {

            // If space exists, increase the logical entry count.
            if (numEntries < board.length) {
                numEntries++;
            }

            // Begin at the last active position.
            int position = numEntries - 1;

            // Shift every lower score right to create the correct opening.
            while (position > 0
                    && board[position - 1].getScore() < newScore) {
                board[position] = board[position - 1];
                position--;
            }

            board[position] = entry;
        }
    }

    public GameEntry remove(int index) {
        if (index < 0 || index >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        GameEntry removed = board[index];

        for (int position = index; position < numEntries - 1; position++) {
            board[position] = board[position + 1];
        }

        board[numEntries - 1] = null;
        numEntries--;
        return removed;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(board, numEntries));
    }
}

public class ScoreboardDemo {

    public static void main(String[] args) {
        Scoreboard board = new Scoreboard(4);

        board.add(new GameEntry("Alice", 950));
        board.add(new GameEntry("Bob", 880));
        board.add(new GameEntry("Eva", 820));
        board.add(new GameEntry("Cara", 900));

        // The array is full; 700 is below its lowest stored score, so ignored.
        board.add(new GameEntry("Dan", 700));

        System.out.println("Sorted board: " + board);

        GameEntry removed = board.remove(1);
        System.out.println("Removed index 1: " + removed);
        System.out.println("Board after removal: " + board);
    }
}

/*
Expected output:
Sorted board: [(Alice, 950), (Cara, 900), (Bob, 880), (Eva, 820)]
Removed index 1: (Cara, 900)
Board after removal: [(Alice, 950), (Bob, 880), (Eva, 820)]
*/
