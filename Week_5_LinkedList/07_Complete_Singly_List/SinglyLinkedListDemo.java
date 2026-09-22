/*
 * CONCEPT: Complete generic singly linked-list implementation.
 *
 * This combines the nested Node<E>, accessors, addFirst(), addLast(),
 * removeFirst(), and removeLast() into one reusable class.
 */

class SinglyLinkedList<E> {
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : head.element;
    }

    public E last() {
        return isEmpty() ? null : tail.element;
    }

    public void addFirst(E element) {
        head = new Node<E>(element, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

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
            return null;
        }

        E removed = head.element;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return removed;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E removed = tail.element;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> previous = head;
            while (previous.next != tail) {
                previous = previous.next;
            }
            previous.next = null;
            tail = previous;
        }
        size--;
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.element);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        return result.append("]").toString();
    }
}

public class SinglyLinkedListDemo {

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");

        System.out.println("List: " + list);
        System.out.println("First/last: " + list.first() + "/" + list.last());
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("Remaining: " + list);
        System.out.println("Size: " + list.size());
    }
}

/*
Expected output:
List: [A, B, C, D]
First/last: A/D
Removed first: A
Removed last: D
Remaining: [B, C]
Size: 2
*/
