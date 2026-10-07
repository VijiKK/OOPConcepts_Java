/*
 * CONCEPT: A recursion trace has a call phase and a return phase.
 *
 * factorial(4) first calls factorial(3), factorial(2), and so on. After the
 * base case returns 1, each waiting call multiplies and returns its answer.
 */
public class FactorialTraceDemo {

    static long factorial(int n, int depth) {
        String indent = "  ".repeat(depth); // Indentation makes stack depth visible.
        System.out.println(indent + "CALL factorial(" + n + ")");

        if (n == 0) {
            System.out.println(indent + "RETURN 1 (base case)");
            return 1; // 0! is defined as 1.
        }

        long smallerAnswer = factorial(n - 1, depth + 1); // Calls travel downward.
        long answer = n * smallerAnswer;                  // Answers combine upward.

        System.out.println(indent + "RETURN " + n + " * "
                + smallerAnswer + " = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        long answer = factorial(n, 0);

        System.out.println(n + "! = " + answer);
        System.out.println("Time O(n), call-stack space O(n)");
    }
}
