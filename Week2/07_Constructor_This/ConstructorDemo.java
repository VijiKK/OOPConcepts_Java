// This class requires initial state through its constructor.
class Student {
    // These instance fields belong to each Student object.
    String name;
    int score;

    // A constructor has the same name as the class and has no return type.
    Student(String name, int score) {
        // this.name is the field; name is the parameter received by the constructor.
        this.name = name;
        // The same field-versus-parameter distinction applies to score.
        this.score = score;
    }

    // This instance method displays the state initialized by the constructor.
    void displayInformation() {
        System.out.println(name + " scored " + score + ".");
    }
}

public class ConstructorDemo {
    // main() is static, so Java can call it before any Student object exists.
    public static void main(String[] args) {
        // The constructor runs automatically when the object is created.
        Student student = new Student("Alice", 92);
        // The object is ready to use because both fields were initialized.
        student.displayInformation();
    }
}

/* Expected output:
Alice scored 92.
*/
