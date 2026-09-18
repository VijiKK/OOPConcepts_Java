/*
 * CONCEPT: Dynamic method lookup (dynamic binding).
 *
 * The reference type determines which method names the compiler permits.
 * The actual object type determines which overridden method runs at runtime.
 */

class Question {
    public void display() {
        System.out.println("Displaying a general question.");
    }
}

class ChoiceQuestion extends Question {
    @Override
    public void display() {
        System.out.println("Displaying a choice question with choices.");
    }

    public void addChoice(String choice) {
        System.out.println("Added choice: " + choice);
    }
}

class NumericQuestion extends Question {
    @Override
    public void display() {
        System.out.println("Displaying a question expecting a number.");
    }
}

public class DynamicLookupDemo {

    public static void main(String[] args) {
        // Every variable has the same declared reference type: Question.
        Question first = new Question();
        Question second = new ChoiceQuestion();
        Question third = new NumericQuestion();

        first.display();  // Actual object is Question.
        second.display(); // Actual object is ChoiceQuestion.
        third.display();  // Actual object is NumericQuestion.

        /*
         * This is not allowed even though second refers to a ChoiceQuestion:
         * second.addChoice("A");
         * The Question reference type does not declare addChoice(). A later
         * example shows how a checked cast can recover subclass access.
         */
    }
}

/*
Expected output:
Displaying a general question.
Displaying a choice question with choices.
Displaying a question expecting a number.
*/
