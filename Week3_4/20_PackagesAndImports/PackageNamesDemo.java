import edu.utc.cpsc5002.Course;

public class PackageNamesDemo {
    public static void main(String[] args) {
        // The package path edu/utc/cpsc5002 contains Course.java.
        Course course = new Course();
        System.out.println("Course: " + course.getCode());
        System.out.println("Full course class name: " + course.getClass().getName());

        // These unrelated library classes share the simple name Timer.
        // Their full package names tell Java exactly which class we mean.
        System.out.println("Timer 1: " + java.util.Timer.class.getName());
        System.out.println("Timer 2: " + javax.swing.Timer.class.getName());
    }
}

/* Expected output:
Course: CPSC 5002
Full course class name: edu.utc.cpsc5002.Course
Timer 1: java.util.Timer
Timer 2: javax.swing.Timer
*/
