/*
 * CONCEPTS: Upcasting, downcasting, and safe instanceof checks.
 *
 * Upcasting from a subclass to a superclass is automatic. Downcasting moves
 * back to a more specific type and must be explicit. instanceof should check
 * the actual object first so an invalid cast does not throw an exception.
 */

class Question {
    public void display() {
        System.out.println("Question display method.");
    }
}

class ChoiceQuestion extends Question {
    private int choiceCount;

    public void addChoice() {
        choiceCount++;
    }

    public int getChoiceCount() {
        return choiceCount;
    }

    @Override
    public void display() {
        System.out.println("ChoiceQuestion display method.");
    }
}

public class CastingDemo {

    public static void main(String[] args) {
        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.addChoice();
        choiceQuestion.addChoice();

        // Upcast: automatic and safe because ChoiceQuestion is a Question.
        Question questionReference = choiceQuestion;
        questionReference.display();

        // Check the actual type before explicitly downcasting.
        if (questionReference instanceof ChoiceQuestion) {
            ChoiceQuestion recovered = (ChoiceQuestion) questionReference;
            System.out.println("Choice count: "
                    + recovered.getChoiceCount());
        }

        Object unrelated = "I am a String";
        if (!(unrelated instanceof ChoiceQuestion)) {
            System.out.println("The String cannot be cast to ChoiceQuestion.");
        }

        // instanceof returns false for null; it does not throw an exception.
        Object missing = null;
        System.out.println("null is a ChoiceQuestion: "
                + (missing instanceof ChoiceQuestion));

        // WRONG (leave commented): would throw ClassCastException at runtime.
        // ChoiceQuestion invalid = (ChoiceQuestion) unrelated;
    }
}

/*
Expected output:
ChoiceQuestion display method.
Choice count: 2
The String cannot be cast to ChoiceQuestion.
null is a ChoiceQuestion: false
*/
