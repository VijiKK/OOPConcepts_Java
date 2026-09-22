/*
 * CONCEPT: A singly linked-list object tracks head, tail, and size.
 *
 * head points to the first node, tail points to the last node, and size counts
 * nodes. For an empty list, head and tail are null and size is zero. In a
 * one-node list, head and tail refer to the same node.
 */

class SinglyList<E> {
    // static means a Node does not silently hold a reference to its list.
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E nodeElement, Node<E> nextNode) {
            element = nodeElement;
            next = nextNode;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyList() {
        head = null;
        tail = null;
        size = 0;
    }

    // This constructor creates a one-element list for the accessor demo.
    public SinglyList(E firstElement) {
        Node<E> onlyNode = new Node<E>(firstElement, null);
        head = onlyNode;
        tail = onlyNode;
        size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Accessors return an element without removing its node.
    public E first() {
        return isEmpty() ? null : head.element;
    }

    public E last() {
        return isEmpty() ? null : tail.element;
    }

    public boolean headAndTailAreSame() {
        return head == tail;
    }
}

public class SinglyAccessorsDemo {

    public static void main(String[] args) {
        SinglyList<String> empty = new SinglyList<String>();
        System.out.println("Empty size: " + empty.size());
        System.out.println("Empty isEmpty: " + empty.isEmpty());
        System.out.println("Empty first: " + empty.first());

        SinglyList<String> oneNode = new SinglyList<String>("A");
        System.out.println("One-node size: " + oneNode.size());
        System.out.println("One-node first: " + oneNode.first());
        System.out.println("One-node last: " + oneNode.last());
        System.out.println("Head and tail share the node: "
                + oneNode.headAndTailAreSame());
    }
}

/*
Expected output:
Empty size: 0
Empty isEmpty: true
Empty first: null
One-node size: 1
One-node first: A
One-node last: A
Head and tail share the node: true
*/
