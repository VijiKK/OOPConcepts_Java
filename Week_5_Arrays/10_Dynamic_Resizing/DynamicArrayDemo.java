import java.util.Arrays;

/*
 * CONCEPT: An array's own length never changes.
 *
 * A "resizable array" creates a larger array and copies the old elements.
 * Arrays.copyOf(original, newLength) returns the new array reference. The old
 * array becomes eligible for garbage collection after no references remain.
 */

class SimpleDynamicArray {
    private String[] elements;
    private int size;

    public SimpleDynamicArray(int initialCapacity) {
        elements = new String[initialCapacity];
        size = 0;
    }

    public void add(String value) {
        if (size == elements.length) {
            // Double capacity. The logical size remains unchanged.
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
            System.out.println("Resized capacity to " + newCapacity);
        }

        elements[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    @Override
    public String toString() {
        // Show only logical elements, not unused capacity cells.
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}

public class DynamicArrayDemo {

    public static void main(String[] args) {
        SimpleDynamicArray names = new SimpleDynamicArray(2);

        names.add("A");
        names.add("B");
        names.add("C"); // Full at size 2, so capacity grows to 4.
        names.add("D");
        names.add("E"); // Full at size 4, so capacity grows to 8.

        System.out.println("Elements: " + names);
        System.out.println("Logical size: " + names.size());
        System.out.println("Physical capacity: " + names.capacity());
    }
}

/*
Expected output:
Resized capacity to 4
Resized capacity to 8
Elements: [A, B, C, D, E]
Logical size: 5
Physical capacity: 8
*/
