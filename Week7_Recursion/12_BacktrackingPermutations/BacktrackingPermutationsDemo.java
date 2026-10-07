import java.util.ArrayList;
import java.util.List;

/*
 * CONCEPT: Multiple recursion and backtracking.
 *
 * At each position, the method tries every unused choice. The pattern is:
 * choose, recurse, undo, then try the next choice. Undoing restores the state
 * for sibling branches in the recursion tree.
 */
public class BacktrackingPermutationsDemo {

    static void generate(List<Character> choices, StringBuilder current) {
        if (choices.isEmpty()) {
            System.out.println(current); // A complete arrangement is one solution.
            return;
        }

        for (int i = 0; i < choices.size(); i++) {
            char chosen = choices.remove(i); // CHOOSE and mark the value in use.
            current.append(chosen);

            generate(choices, current); // RECURSE using the smaller choice set.

            current.deleteCharAt(current.length() - 1); // UNDO the partial solution.
            choices.add(i, chosen);                    // Restore the removed choice.
        }
    }

    public static void main(String[] args) {
        List<Character> choices = new ArrayList<>(List.of('A', 'B', 'C'));

        System.out.println("All arrangements:");
        generate(choices, new StringBuilder());
        System.out.println("Three choices create 3! = 6 permutations.");
    }
}
