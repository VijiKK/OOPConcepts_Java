// Import ArrayList from Java's standard collection library.
import java.util.ArrayList;

public class GenericsBasicDemo {
    // main() creates two lists with different allowed element types.
    public static void main(String[] args) {
        // <String> tells Java that this list accepts only String objects.
        ArrayList<String> names = new ArrayList<String>();
        // Both arguments are String values, so the compiler accepts them.
        names.add("Alice");
        names.add("Ben");
        // The compiler catches this type mistake before the program can run:
        // names.add(25); // Compile-time error: 25 is not a String.

        // The same collection class can be reused with a different element type.
        ArrayList<Integer> scores = new ArrayList<Integer>();
        // int literals are automatically boxed into Integer objects for the list.
        scores.add(92);
        scores.add(85);

        // ArrayList supplies a readable String representation of its elements.
        System.out.println("Names: " + names);
        System.out.println("Scores: " + scores);
    }
}

/* Expected output:
Names: [Alice, Ben]
Scores: [92, 85]
*/
