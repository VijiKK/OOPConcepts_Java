/*
 * CONCEPT: Modulo arithmetic maps logical queue positions to array indices.
 *
 * The array remains physically linear. We only treat its indices as circular.
 * With capacity 5, adding 1 and taking remainder 5 maps index 4 back to 0.
 */
public class WrapAroundDemo {

    /** Prints the rear-index formula for several logical queue sizes. */
    public static void main(String[] args) {
        int capacity = 5; // Valid physical indices are 0 through 4.
        int front = 3;    // The logical queue currently begins at index 3.

        System.out.println("Capacity: " + capacity);
        System.out.println("Front index: " + front);

        for (int size = 0; size < capacity; size++) {
            // Add the logical offset, then wrap into 0..capacity-1.
            int rearInsertionIndex = (front + size) % capacity;
            System.out.println("If size is " + size
                    + ", next enqueue index is " + rearInsertionIndex);
        }

        int nextFront = (4 + 1) % capacity; // 5 % 5 is 0.
        System.out.println("Front after moving past index 4: " + nextFront);
    }
}

/*
Expected output:
Capacity: 5
Front index: 3
If size is 0, next enqueue index is 3
If size is 1, next enqueue index is 4
If size is 2, next enqueue index is 0
If size is 3, next enqueue index is 1
If size is 4, next enqueue index is 2
Front after moving past index 4: 0
*/
