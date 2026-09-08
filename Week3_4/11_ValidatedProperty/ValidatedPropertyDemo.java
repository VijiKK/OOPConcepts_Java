class Student {
    // A private field stores the property value.
    private String name;

    Student(String name) {
        // Reuse the setter so construction follows the same validation rule.
        setName(name);
    }

    String getName() {
        return name;
    }

    void setName(String newName) {
        // Reject null and empty text before changing the property.
        if (newName != null && newName.length() > 0) {
            name = newName;
        } else {
            System.out.println("Name cannot be empty.");
        }
    }
}

public class ValidatedPropertyDemo {
    public static void main(String[] args) {
        Student student = new Student("Alice");
        System.out.println("Original name: " + student.getName());

        // The invalid request prints a message and leaves the old state unchanged.
        student.setName("");
        System.out.println("Name after invalid change: " + student.getName());
    }
}

/* Expected output:
Original name: Alice
Name cannot be empty.
Name after invalid change: Alice
*/
