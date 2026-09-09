class Student {
    // A private field stores the property value.
    private String name;

    Student(String name) {
        // Reuse the setter so construction follows the same validation rule.
        setName(name);
    }

    String getName() {
        // A getter reads the property without changing it.
        return name;
    }

    void setName(String newName) {
        // && uses short-circuit evaluation, so trim() is not called when newName is null.
        if (newName != null && newName.trim().length() > 0) {
            // The field changes only after the new value passes validation.
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

        // A valid display-name change is accepted.
        student.setName("Alice Smith");
        System.out.println("Updated name: " + student.getName());

        // The invalid request prints a message and leaves the old state unchanged.
        student.setName("   ");
        System.out.println("Name after invalid change: " + student.getName());
    }
}

/* Expected output:
Original name: Alice
Updated name: Alice Smith
Name cannot be empty.
Name after invalid change: Alice Smith
*/
