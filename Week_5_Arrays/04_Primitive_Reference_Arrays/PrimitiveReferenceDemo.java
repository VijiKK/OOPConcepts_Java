/*
 * CONCEPT: Primitive arrays hold values; object arrays hold references.
 *
 * A char[] cell contains a char value directly. A Student[] cell contains a
 * reference to a Student object that exists separately. An unassigned object
 * array cell contains null.
 */

class Student {
    private String name;

    public Student(String studentName) {
        name = studentName;
    }

    public void setName(String studentName) {
        name = studentName;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class PrimitiveReferenceDemo {

    public static void main(String[] args) {
        // Every cell directly stores one primitive char value.
        char[] letters = {'S', 'A', 'M', 'P', 'L', 'E'};
        System.out.println("Primitive value: " + letters[0]);

        // The array initially contains three null references.
        Student[] students = new Student[3];
        students[0] = new Student("Tom");
        students[1] = new Student("Alice");

        System.out.println("First student: " + students[0]);
        System.out.println("Third cell is null: " + (students[2] == null));

        // Both cells now refer to the same Student object.
        students[2] = students[0];
        students[2].setName("Thomas");

        // Changing the shared object is visible through either reference.
        System.out.println("Cell 0 after shared-object change: " + students[0]);
        System.out.println("Cells 0 and 2 share one object: "
                + (students[0] == students[2]));
    }
}

/*
Expected output:
Primitive value: S
First student: Tom
Third cell is null: true
Cell 0 after shared-object change: Thomas
Cells 0 and 2 share one object: true
*/
