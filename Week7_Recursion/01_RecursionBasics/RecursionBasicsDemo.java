/*
 * CONCEPT: Recursion means that a method calls itself on a smaller problem.
 *
 * Every recursive method needs a base case that stops the calls and a recursive
 * case that moves toward that base case. If the input never makes progress,
 * calls continue until Java throws StackOverflowError.
 */
public class RecursionBasicsDemo {

    static void countdown(int n) {
        if (n == 0) {
            System.out.println("Liftoff!"); // Base case performs no recursive call.
            return;                         // Return to the waiting caller.
        }

        System.out.println(n); // Process the current, larger problem.
        countdown(n - 1);      // Recursive case uses a smaller value.
    }

    public static void main(String[] args) {
        int startingValue = 4;

        System.out.println("Countdown begins:");
        countdown(startingValue);
        System.out.println("All recursive calls have returned.");
    }
}
