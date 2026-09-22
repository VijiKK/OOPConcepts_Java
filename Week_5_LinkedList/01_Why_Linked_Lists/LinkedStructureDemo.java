/*
 * CONCEPT: A linked list stores elements inside connected node objects.
 *
 * Unlike an array, the nodes do not need adjacent numbered cells. Each node
 * stores an element and a reference to the next node. The final next reference
 * is null, which marks the end of a singly linked list.
 */
public class LinkedStructureDemo {

    // A node is the building block of a singly linked list.
    private static class Node {
        private String element;
        private Node next;

        public Node(String nodeElement, Node nextNode) {
            element = nodeElement;
            next = nextNode;
        }
    }

    public static void main(String[] args) {
        // Create three separate node objects.
        Node first = new Node("A", null);
        Node second = new Node("B", null);
        Node third = new Node("C", null);

        // Connect them: first -> second -> third -> null.
        first.next = second;
        second.next = third;

        // head stores the reference to the first node.
        Node head = first;

        // Follow next references until the null end marker is reached.
        Node current = head;
        while (current != null) {
            System.out.print(current.element);
            current = current.next;
            System.out.print(current == null ? " -> null" : " -> ");
        }
        System.out.println();

        /*
         * Inserting/removing a known node changes references instead of
         * shifting all later elements as an array would.
         */
    }
}

/*
Expected output:
A -> B -> C -> null
*/
