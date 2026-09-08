// A class should represent one clear concept from the problem domain.
class Book {
    // These fields describe the state of one book.
    String title;
    String author;

    // The constructor requires the information needed to create a useful Book.
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // This behavior belongs in Book because it describes a book.
    void displayDetails() {
        System.out.println(title + " by " + author);
    }
}

// This starter class contains main() and coordinates the demonstration.
public class DiscoveringClassesDemo {
    public static void main(String[] args) {
        // Nouns in a library problem, such as Book and Member, suggest class names.
        Book book = new Book("Java Basics", "A. Teacher");
        book.displayDetails();
    }
}

/* Expected output:
Java Basics by A. Teacher
*/
