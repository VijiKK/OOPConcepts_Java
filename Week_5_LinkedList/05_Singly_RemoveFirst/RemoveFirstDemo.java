/*
 * CONCEPT: removeFirst() advances head to the second node in O(1) time.
 *
 * After no list reference points to the former first node, Java's garbage
 * collector may reclaim it. Removing the only node must also clear tail.
 */

class RemovableFrontList<E> {
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

    public boolean isEmpty() {
        return size == 0;
    }

    // Setup helper so the demonstration can focus on removal.
    public void addLast(E element) {
        Node<E> newest = new Node<E>(element, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.next = newest;
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null; // Nothing can be removed.
        }

        E removedElement = head.element;
        head = head.next;
        size--;

        if (size == 0) {
            // The only node was removed, so no last node remains.
            tail = null;
        }

        return removedElement;
    }

    public E first() {
        return isEmpty() ? null : head.element;
    }

    public E last() {
        return isEmpty() ? null : tail.element;
    }
}

public class RemoveFirstDemo {

    public static void main(String[] args) {
        RemovableFrontList<String> list = new RemovableFrontList<String>();
        list.addLast("A");
        list.addLast("B");

        System.out.println("Removed: " + list.removeFirst());
        System.out.println("New first: " + list.first());

        // Remove the only remaining node. Both head and tail become null.
        System.out.println("Removed: " + list.removeFirst());
        System.out.println("Empty first: " + list.first());
        System.out.println("Empty last: " + list.last());

        // The method safely returns null when the list is already empty.
        System.out.println("Remove from empty: " + list.removeFirst());
    }
}

/*
Expected output:
Removed: A
New first: B
Removed: B
Empty first: null
Empty last: null
Remove from empty: null
*/
