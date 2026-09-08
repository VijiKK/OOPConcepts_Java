// IOException is a checked exception supplied by Java's standard library.
import java.io.IOException;

public class ThrowVsThrowsDemo {
    // throws is part of the method header. It declares that this method may
    // send a checked IOException to its caller instead of handling it here.
    static void checkFileName(String fileName) throws IOException {
        // isEmpty() is true when the String contains zero characters.
        if (fileName.isEmpty()) {
            // throw is a statement. It creates and sends the exception now.
            throw new IOException("File name cannot be empty");
        }
        // This line runs only when no exception was thrown.
        System.out.println("File name accepted: " + fileName);
    }

    public static void main(String[] args) {
        // Because IOException is checked, the caller must catch it or declare throws.
        try {
            // The first call completes normally.
            checkFileName("notes.txt");
            // The second call throws, so control immediately moves to catch.
            checkFileName("");
        } catch (IOException exception) {
            // Handling the exception satisfies Java's checked-exception rule.
            System.out.println("Caught: " + exception.getMessage());
        }
    }
}

/*
throw  -> action
throws -> declaration

Expected output:
File name accepted: notes.txt
Caught: File name cannot be empty
*/
