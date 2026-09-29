import java.util.Scanner; // Reads a simulated/user yes-no answer.

/* CONCEPT: Internal nodes ask questions; leaves store final decisions/actions. */
public class DecisionTreeDemo {
    private static class Node {
        private String text; // Question for internal node or action for leaf.
        private Node yes;    // Branch selected by a yes answer.
        private Node no;     // Branch selected by a no answer.
        public Node(String value) { text = value; }
        public boolean isLeaf() { return yes == null && no == null; }
    }

    /** Follows answers from root until a decision leaf is reached. */
    private static String decide(Node node, Scanner input) {
        if (node.isLeaf()) { return node.text; } // Base case: final action.
        System.out.print(node.text + " (yes/no): ");
        String answer = input.nextLine().trim(); // Normalize surrounding spaces.
        if (answer.equalsIgnoreCase("yes")) {
            return decide(node.yes, input);      // Follow the yes subtree.
        }
        return decide(node.no, input);           // Any other answer follows no.
    }

    /** Builds a weather decision tree and uses prepared answers for repeatability. */
    public static void main(String[] args) {
        Node raining = new Node("Is it raining?");       // Root question.
        raining.yes = new Node("Take an umbrella");      // Decision leaf.
        raining.no = new Node("Is it cold?");            // Another question.
        raining.no.yes = new Node("Wear a coat");
        raining.no.no = new Node("Wear a light jacket");

        Scanner simulatedInput = new Scanner("no\nyes\n"); // Chosen path.
        System.out.println("Decision: " + decide(raining, simulatedInput));
        simulatedInput.close(); // Release the scanner resource.
    }
}

/* Expected output:
Is it raining? (yes/no): Is it cold? (yes/no): Decision: Wear a coat
*/
