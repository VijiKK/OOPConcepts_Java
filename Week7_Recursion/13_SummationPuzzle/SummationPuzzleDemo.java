import java.util.ArrayList;
import java.util.List;

/*
 * CONCEPT: Apply multiple recursion to a small summation puzzle.
 *
 * For cbb + ba = abc, a, b, and c must use 7, 8, and 9 exactly once.
 * This is the textbook PuzzleSolve pattern: S is the partial assignment and U
 * is the set of unused choices. Backtracking enumerates every assignment.
 */
public class SummationPuzzleDemo {

    static void puzzleSolve(List<Integer> unused, List<Integer> assignment) {
        if (unused.isEmpty()) {
            int a = assignment.get(0);
            int b = assignment.get(1);
            int c = assignment.get(2);

            int cbb = 100 * c + 10 * b + b;
            int ba = 10 * b + a;
            int abc = 100 * a + 10 * b + c;

            if (cbb + ba == abc) {
                System.out.println("Solution: " + cbb + " + " + ba + " = " + abc);
            }
            return;
        }

        for (int i = 0; i < unused.size(); i++) {
            int chosen = unused.remove(i); // Choose a digit for the next letter.
            assignment.add(chosen);

            puzzleSolve(unused, assignment); // Explore below this choice recursively.

            assignment.remove(assignment.size() - 1); // Undo letter assignment.
            unused.add(i, chosen);                     // Restore available digit.
        }
    }

    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>(List.of(7, 8, 9));

        // assignment corresponds to textbook sequence S; digits corresponds to set U.
        puzzleSolve(digits, new ArrayList<>());
        System.out.println("Backtracking tested all 3! assignments.");
    }
}
