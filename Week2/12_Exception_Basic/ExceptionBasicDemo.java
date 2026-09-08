public class ExceptionBasicDemo {
    // This first exception lesson runs safely; the failing line remains commented.
    public static void main(String[] args) {
        // "123" contains only digits, so parseInt() can convert it successfully.
        String text = "123";
        // parseInt converts numeric text into an int during program execution.

        // The returned int is stored in number.
        int number = Integer.parseInt(text);
        // Display the successful conversion before discussing the failing case.
        System.out.println("Converted number: " + number);

        // "hello" cannot be represented as an int. Uncommenting this line causes
        // a NumberFormatException and stops the program because it is not handled.
        // int invalidNumber = Integer.parseInt("hello");
        // This line still runs because the failing demonstration is commented out.
        System.out.println("An exception happens while a program is running.");
    }
}

/* Expected output:
Converted number: 123
An exception happens while a program is running.
*/
