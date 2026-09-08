// A class is a blueprint that describes what Student objects contain and can do.
class Student {
    // These instance fields store the state of one particular Student object.
    String name;
    int score;

    // A method describes behavior that a Student object can perform.
    void displayInformation() {
        // Java uses the name and score belonging to the object that called this method.
        System.out.println(name + " has a score of " + score + ".");
    }
}

public class ClassAndObjectDemo {
    // main() is the starting point when we run ClassAndObjectDemo.
    public static void main(String[] args) {
        // new Student() creates the first object from the Student blueprint.
        Student firstStudent = new Student();
        // The dot operator selects a field that belongs to firstStudent.
        firstStudent.name = "Alice";
        firstStudent.score = 92;

        // This is a separate object, so changing it does not change firstStudent.
        Student secondStudent = new Student();
        secondStudent.name = "Ben";
        secondStudent.score = 85;

        // Each object uses its own field values when the same method is called.
        firstStudent.displayInformation();
        secondStudent.displayInformation();
    }
}

/* Expected output:
Alice has a score of 92.
Ben has a score of 85.
*/
