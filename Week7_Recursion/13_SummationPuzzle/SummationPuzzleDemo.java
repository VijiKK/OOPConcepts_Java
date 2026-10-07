import java.util.ArrayList;
import java.util.List;

/*
 * CONCEPT: Apply multiple recursion to a small summation puzzle.
 *
 * For cbb + ba = abc, a, b, and c must use 7, 8, and 9 exactly once.
 * Backtracking enumerates digit assignments and tests each complete arrangement.
 */
public class SummationPuzzleDemo {

    static void solve(List<Integer> unused, List<Integer> assignment) {
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

            solve(unused, assignment); // Explore all assignments below this choice.

            assignment.remove(assignment.size() - 1); // Undo letter assignment.
            unused.add(i, chosen);                     // Restore available digit.
        }
    }

    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>(List.of(7, 8, 9));

        solve(digits, new ArrayList<>());
        System.out.println("Backtracking tested all 3! assignments.");
    }
}
