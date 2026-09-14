// Import lets this file use Student instead of writing school.Student each time.
import school.Student;

public class PackageDemo {
    public static void main(String[] args) {
        Student student = new Student("Alice");
        // A fully qualified name works without an import. It names the same class.
        school.Student anotherStudent = new school.Student("Bob");

        // Student's complete class name is school.Student.
        System.out.println("Student: " + student.getName());
        System.out.println("Fully qualified name: " + anotherStudent.getName());
        System.out.println("Class: " + student.getClass().getName());
    }
}

/* Expected output:
Student: Alice
Fully qualified name: Bob
Class: school.Student
*/
