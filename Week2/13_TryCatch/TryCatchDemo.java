public class TryCatchDemo {
    // This helper method performs the same conversion for different inputs.
    static void convertAndDisplay(String input) {
        // Java first attempts the code inside try.
        try {
            // parseInt() may throw NumberFormatException for nonnumeric text.
            int number = Integer.parseInt(input);
            // This statement runs only if the conversion succeeds.
            System.out.println(input + " became the number " + number + ".");
        } catch (NumberFormatException exception) {
            // catch runs only when the matching exception occurs in try.
            System.out.println(input + " is not a valid integer.");
        }
    }

    public static void main(String[] args) {
        // This input completes the try block normally.
        convertAndDisplay("25");
        // This input causes parseInt() to transfer control to catch.
        convertAndDisplay("hello");
        // Execution reaches here because the exception was handled.
        System.out.println("The program continues.");
    }
}

/* Expected output:
25 became the number 25.
hello is not a valid integer.
The program continues.
*/
