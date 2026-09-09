class Student {
    // final prevents the field from being assigned again after construction.
    private final int studentId;
    private String name;

    Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    int getStudentId() {
        // Outside code can read the ID through this getter.
        return studentId;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        // The name is a changeable property, so it has a setter.
        this.name = name;
    }
}

public class ReadOnlyPropertyDemo {
    public static void main(String[] args) {
        Student student = new Student(1001, "Alice");
        // The following line would not compile because no setStudentId() method exists:
        // student.setStudentId(2002);

        // The display name may change without changing the student's identity.
        student.setName("Alice Smith");

        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
    }
}

/* Expected output:
ID: 1001
Name: Alice Smith
*/
