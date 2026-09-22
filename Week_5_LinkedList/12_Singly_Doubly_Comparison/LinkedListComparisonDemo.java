/*
 * CONCEPT: Compare the links available in singly and doubly linked nodes.
 *
 * Both structures can move forward. Only the doubly linked node can move
 * backward directly. This additional reference explains the memory/operation
 * tradeoff between the two designs.
 */
public class LinkedListComparisonDemo {

    private static class SinglyNode {
        private String element;
        private SinglyNode next;

        public SinglyNode(String nodeElement) {
            element = nodeElement;
        }
    }

    private static class DoublyNode {
        private String element;
        private DoublyNode previous;
        private DoublyNode next;

        public DoublyNode(String nodeElement) {
            element = nodeElement;
        }
    }

    public static void main(String[] args) {
        SinglyNode singlyA = new SinglyNode("A");
        SinglyNode singlyB = new SinglyNode("B");
        SinglyNode singlyC = new SinglyNode("C");
        singlyA.next = singlyB;
        singlyB.next = singlyC;

        // To find C's predecessor, a singly list must walk from its head.
        int singlySteps = 0;
        SinglyNode current = singlyA;
        while (current.next != singlyC) {
            current = current.next;
            singlySteps++;
        }
        // Count the final link inspection from B to C.
        singlySteps++;

        DoublyNode doublyA = new DoublyNode("A");
        DoublyNode doublyB = new DoublyNode("B");
        DoublyNode doublyC = new DoublyNode("C");
        doublyA.next = doublyB;
        doublyB.previous = doublyA;
        doublyB.next = doublyC;
        doublyC.previous = doublyB;

        // C.previous gives B directly; no traversal from A is required.
        System.out.println("Singly predecessor of C: " + current.element);
        System.out.println("Singly links inspected: " + singlySteps);
        System.out.println("Doubly predecessor of C: "
                + doublyC.previous.element);
        System.out.println("Doubly can move backward: "
                + (doublyC.previous == doublyB));

        System.out.println("Singly node references per node: 1");
        System.out.println("Doubly node references per node: 2");
    }
}

/*
Expected output:
Singly predecessor of C: B
Singly links inspected: 2
Doubly predecessor of C: B
Doubly can move backward: true
Singly node references per node: 1
Doubly node references per node: 2
*/
