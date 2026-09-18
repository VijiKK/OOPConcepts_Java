import java.util.ArrayList;

/*
 * CONCEPTS: Method overriding and super.method().
 *
 * ChoiceQuestion needs a more detailed display than Question. It overrides
 * display(), reuses the superclass version through super.display(), and then
 * adds the choices. This extends behavior instead of copying it.
 */

class Question {
    private String text;

    public void setText(String questionText) {
        text = questionText;
    }

    public void display() {
        System.out.println(text);
    }
}

class ChoiceQuestion extends Question {
    private ArrayList<String> choices = new ArrayList<String>();

    public void addChoice(String choice) {
        choices.add(choice);
    }

    // @Override asks the compiler to verify that this truly overrides.
    @Override
    public void display() {
        // Call Question's display() instead of recursively calling this one.
        super.display();

        // Add the specialized behavior after the reused behavior.
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ": " + choices.get(i));
        }
    }
}

public class OverridingSuperDemo {

    public static void main(String[] args) {
        ChoiceQuestion question = new ChoiceQuestion();
        question.setText("Which keyword calls a superclass method?");
        question.addChoice("this");
        question.addChoice("super");

        // Java calls ChoiceQuestion's overridden display().
        question.display();
    }
}

/*
Expected output:
Which keyword calls a superclass method?
1: this
2: super
*/
