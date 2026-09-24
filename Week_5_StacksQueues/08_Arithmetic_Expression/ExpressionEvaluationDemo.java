import java.util.ArrayDeque; // Concrete implementation for both stacks.
import java.util.Deque;      // Interface providing push, pop, and peek.

/*
 * CONCEPT: Two stacks can enforce arithmetic operator precedence.
 *
 * One stack holds integer values and another holds operators. Before pushing a
 * new operator, evaluate operators that have greater or equal precedence.
 * The expression uses spaces so this introductory parser can read each token.
 */
public class ExpressionEvaluationDemo {

    /** Converts an operator into a numeric precedence level. */
    public static int precedence(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == '+' || operator == '-') {
            return 1;
        }
        return 0;
    }

    /** Pops two values and one operator, computes, and pushes the result. */
    public static void performTopOperation(
            Deque<Integer> values, Deque<Character> operators) {
        int right = values.pop(); // The first pop is the right operand.
        int left = values.pop();  // The second pop is the left operand.
        char operator = operators.pop(); // Most recently deferred operator.

        int result;
        if (operator == '+') {
            result = left + right;
        } else if (operator == '-') {
            result = left - right;
        } else if (operator == '*') {
            result = left * right;
        } else {
            result = left / right;
        }

        values.push(result); // The result may become an operand later.
        System.out.println("Calculated " + left + " " + operator
                + " " + right + " = " + result);
    }

    /** Evaluates a space-separated integer expression containing +, -, *, /. */
    public static int evaluate(String expression) {
        Deque<Integer> values = new ArrayDeque<Integer>();
        Deque<Character> operators = new ArrayDeque<Character>();

        for (String token : expression.split(" ")) { // Read tokens left to right.
            if (token.matches("\\d+")) {
                values.push(Integer.parseInt(token)); // Convert text to an int.
            } else {
                char incoming = token.charAt(0);
                while (!operators.isEmpty()
                        && precedence(operators.peek()) >= precedence(incoming)) {
                    performTopOperation(values, operators);
                }
                operators.push(incoming); // Defer this operator.
            }
        }

        while (!operators.isEmpty()) {
            performTopOperation(values, operators);
        }
        return values.pop(); // One final value remains after all operations.
    }

    /** Evaluates the expression used in the source deck. */
    public static void main(String[] args) {
        String expression = "14 - 3 * 2 + 7";
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + evaluate(expression));
    }
}

/*
Expected output:
Expression: 14 - 3 * 2 + 7
Calculated 3 * 2 = 6
Calculated 14 - 6 = 8
Calculated 8 + 7 = 15
Result: 15
*/
