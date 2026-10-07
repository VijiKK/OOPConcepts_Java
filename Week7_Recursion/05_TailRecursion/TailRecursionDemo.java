import java.util.Arrays;

/*
 * CONCEPT: Tail recursion places the recursive call as the method's last action.
 *
 * Recursive reversal is compared with an equivalent loop. Java does not promise
 * tail-call optimization, so the recursive version still uses O(n) stack space.
 * The iterative version uses O(1) extra space.
 */
public class TailRecursionDemo {

    static void reverseRecursively(int[] values, int left, int right) {
        if (left >= right) {
            return;
        }

        swap(values, left, right);
        reverseRecursively(values, left + 1, right - 1); // Last action: tail recursion.
    }

    static void reverseIteratively(int[] values) {
        int left = 0;
        int right = values.length - 1;

        while (left < right) {
            swap(values, left, right);
            left++;  // Move toward the middle without another method call.
            right--;
        }
    }

    static void swap(int[] values, int first, int second) {
        int temporary = values[first];
        values[first] = values[second];
        values[second] = temporary;
    }

    public static void main(String[] args) {
        int[] recursiveValues = {1, 2, 3, 4, 5};
        int[] iterativeValues = recursiveValues.clone();

        reverseRecursively(recursiveValues, 0, recursiveValues.length - 1);
        reverseIteratively(iterativeValues);

        System.out.println("Recursive: " + Arrays.toString(recursiveValues));
        System.out.println("Iterative: " + Arrays.toString(iterativeValues));
        System.out.println("Same result; different call-stack usage.");
    }
}
