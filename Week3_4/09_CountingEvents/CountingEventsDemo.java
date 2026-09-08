class AttendanceCounter {
    // This field stores how many arrival events have occurred.
    private int studentCount;

    // Each call represents one event and increments the counter by one.
    void recordArrival() {
        studentCount++;
    }

    int getStudentCount() {
        return studentCount;
    }

    void clear() {
        studentCount = 0;
    }
}

public class CountingEventsDemo {
    public static void main(String[] args) {
        AttendanceCounter counter = new AttendanceCounter();

        counter.recordArrival();
        counter.recordArrival();
        counter.recordArrival();
        System.out.println("Students present: " + counter.getStudentCount());

        counter.clear();
        System.out.println("After clear: " + counter.getStudentCount());
    }
}

/* Expected output:
Students present: 3
After clear: 0
*/
