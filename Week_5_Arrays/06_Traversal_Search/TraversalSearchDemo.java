/*
 * CONCEPTS: Array traversal, enhanced for loops, and linear search.
 *
 * Direct access to one known index is O(1). Searching an unsorted array may
 * inspect every element, so its worst-case running time is O(n).
 */
public class TraversalSearchDemo {

    public static int findIndex(String[] names, String target) {
        // Visit valid indices from 0 through names.length - 1.
        for (int index = 0; index < names.length; index++) {
            if (names[index].equals(target)) {
                return index; // Stop as soon as the target is found.
            }
        }

        return -1; // Conventional result meaning "not found."
    }

    public static void main(String[] args) {
        String[] names = {"Tom", "Alice", "Bob", "Eva", "Mike"};

        // Enhanced for loop: useful when the index itself is unnecessary.
        System.out.print("Names:");
        for (String name : names) {
            System.out.print(" " + name);
        }
        System.out.println();

        // One known-index access goes directly to cell 2: O(1).
        System.out.println("Index 2: " + names[2]);

        // Unsorted search checks cells in order: O(n) in the worst case.
        System.out.println("Bob found at index: "
                + findIndex(names, "Bob"));
        System.out.println("Zach found at index: "
                + findIndex(names, "Zach"));
    }
}

/*
Expected output:
Names: Tom Alice Bob Eva Mike
Index 2: Bob
Bob found at index: 2
Zach found at index: -1
*/
