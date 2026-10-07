import java.util.Arrays;

/*
 * CONCEPT: An algorithm transforms input into output through a finite,
 * unambiguous sequence of steps.
 *
 * This example receives an array as input and produces its sum as output.
 * If the input contains n values, the loop performs n additions, so the
 * running time grows linearly: O(n).
 */
public class AlgorithmInputOutputDemo {

    static int sum(int[] numbers) {
        int total = 0; // This variable stores the partial result.

        // Process each input value exactly once.
        for (int number : numbers) {
            total += number; // Add the current value to the partial result.
        }

        return total; // Return the completed output to the caller.
    }

    public static void main(String[] args) {
        int[] input = {4, 7, 2, 9}; // The array is the algorithm's input.
        int output = sum(input);    // Call the algorithm and save its output.

        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output sum: " + output);
        System.out.println("Input size n: " + input.length);
        System.out.println("Time complexity: O(n)");
    }
}
