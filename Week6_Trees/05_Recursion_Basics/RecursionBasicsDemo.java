/*
 * CONCEPT: Recursion means a method calls itself on a smaller problem.
 * A base case stops further calls. Tree recursion uses child subtrees as the
 * smaller problems in the same way this example uses n - 1.
 */
public class RecursionBasicsDemo {

    /** Prints n down to 1, then demonstrates returning/backtracking. */
    private static void countdown(int n) {
        if (n == 0) {                         // Base case stops recursion.
            System.out.println("Base case");
            return;                           // Return to the waiting call.
        }

        System.out.println("Going down: " + n); // Work before recursive call.
        countdown(n - 1);                     // Solve a smaller version.
        System.out.println("Returning from: " + n); // Work during backtracking.
    }

    /** Starts the recursive chain at three. */
    public static void main(String[] args) {
        countdown(3); // Creates waiting calls for 3, 2, and 1.
    }
}

/*
Expected output:
Going down: 3
Going down: 2
Going down: 1
Base case
Returning from: 1
Returning from: 2
Returning from: 3
*/
