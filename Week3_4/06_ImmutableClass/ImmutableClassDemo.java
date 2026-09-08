// An immutable class provides no operation that changes an object after construction.
final class CourseCode {
    private final String department;
    private final int number;

    CourseCode(String department, int number) {
        this.department = department;
        this.number = number;
    }

    String getDepartment() {
        return department;
    }

    int getNumber() {
        return number;
    }

    // There are getters but no setters, so the stored values cannot be replaced.
    String getDisplayCode() {
        return department + " " + number;
    }
}

public class ImmutableClassDemo {
    public static void main(String[] args) {
        CourseCode course = new CourseCode("CPSC", 5002);
        System.out.println("Course: " + course.getDisplayCode());
        System.out.println("The course code cannot be changed after construction.");
    }
}

/* Expected output:
Course: CPSC 5002
The course code cannot be changed after construction.
*/
