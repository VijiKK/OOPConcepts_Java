class Student {
    // final prevents the field from being assigned again after construction.
    private final int studentId;
    private String name;

    Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    int getStudentId() {
        return studentId;
    }

    // There is deliberately no setStudentId() because identity should not change.
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}

public class ReadOnlyPropertyDemo {
    public static void main(String[] args) {
        Student student = new Student(1001, "Alice");
        student.setName("Alice Smith");

        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
    }
}

/* Expected output:
ID: 1001
Name: Alice Smith
*/
