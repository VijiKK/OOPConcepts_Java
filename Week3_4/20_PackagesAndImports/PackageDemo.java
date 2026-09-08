// Import lets this file use Student instead of writing school.Student each time.
import school.Student;

public class PackageDemo {
    public static void main(String[] args) {
        Student student = new Student("Alice");

        // Student's complete class name is school.Student.
        System.out.println("Student: " + student.getName());
        System.out.println("Class: " + student.getClass().getName());
    }
}

/* Expected output:
Student: Alice
Class: school.Student
*/
