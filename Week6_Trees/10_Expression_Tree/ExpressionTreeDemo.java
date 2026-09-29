/*
 * CONCEPT: Expression-tree leaves are operands; internal nodes are operators.
 * Inorder reconstructs infix notation. Postorder naturally evaluates children
 * before applying their parent operator.
 */
public class ExpressionTreeDemo {
    private static class Node {
        private String token; // Number or arithmetic operator.
        private Node left;    // Left operand/subexpression.
        private Node right;   // Right operand/subexpression.
        public Node(String value) { token = value; }
    }

    /** Returns a fully parenthesized infix expression using inorder recursion. */
    private static String infix(Node node) {
        if (node.left == null && node.right == null) { // Operand leaf.
            return node.token;
        }
        return "(" + infix(node.left) + " " + node.token + " "
                + infix(node.right) + ")";
    }

    /** Returns a postfix sequence using Left, Right, Root. */
    private static String postfix(Node node) {
        if (node == null) { return ""; } // Empty subtree contributes nothing.
        return (postfix(node.left) + " " + postfix(node.right) + " "
                + node.token).trim();
    }

    /** Evaluates a subtree after recursively obtaining both operand values. */
    private static int evaluate(Node node) {
        if (node.left == null && node.right == null) {
            return Integer.parseInt(node.token); // Base case: numeric leaf.
        }
        int leftValue = evaluate(node.left);   // Evaluate left subtree first.
        int rightValue = evaluate(node.right); // Then evaluate right subtree.
        if (node.token.equals("+")) { return leftValue + rightValue; }
        if (node.token.equals("-")) { return leftValue - rightValue; }
        return leftValue * rightValue;         // Remaining operator is *.
    }

    /** Builds (2 * (5 - 1)) + (3 * 2), then prints and evaluates it. */
    public static void main(String[] args) {
        Node plus = new Node("+");             // Root operator.
        plus.left = new Node("*"); plus.right = new Node("*");
        plus.left.left = new Node("2");
        plus.left.right = new Node("-");
        plus.left.right.left = new Node("5");
        plus.left.right.right = new Node("1");
        plus.right.left = new Node("3");
        plus.right.right = new Node("2");

        System.out.println("Infix: " + infix(plus));
        System.out.println("Postfix: " + postfix(plus));
        System.out.println("Value: " + evaluate(plus));
    }
}

/* Expected output:
Infix: ((2 * (5 - 1)) + (3 * 2))
Postfix: 2 5 1 - * 3 2 * +
Value: 14
*/
