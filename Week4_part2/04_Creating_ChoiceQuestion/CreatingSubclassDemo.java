import java.util.ArrayList;

/*
 * CONCEPT: Create ChoiceQuestion as a specialized Question.
 *
 * ChoiceQuestion inherits Question's public methods, adds a list of choices,
 * and adds a new addChoice() method. We delay overriding display() so that
 * the inheritance and "added member" ideas remain easy to see.
 */

class Question {
    private String text;
    private String answer;

    public void setText(String questionText) {
        text = questionText;
    }

    public void setAnswer(String correctAnswer) {
        answer = correctAnswer;
    }

    public void display() {
        System.out.println(text);
    }

    public boolean checkAnswer(String response) {
        return answer.equals(response);
    }
}

// ChoiceQuestion inherits the accessible behavior of Question.
class ChoiceQuestion extends Question {
    // This field belongs only to the specialized subclass.
    private ArrayList<String> choices = new ArrayList<String>();

    // This method is also new behavior supplied by ChoiceQuestion.
    public void addChoice(String choice, boolean correct) {
        choices.add(choice);

        if (correct) {
            // The displayed answer is the choice number: 1, 2, 3, ...
            String choiceNumber = Integer.toString(choices.size());
            setAnswer(choiceNumber); // Inherited public method.
        }
    }

    public void displayChoices() {
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + choices.get(i));
        }
    }
}

public class CreatingSubclassDemo {

    public static void main(String[] args) {
        ChoiceQuestion question = new ChoiceQuestion();

        // setText() is inherited; it is not declared again in ChoiceQuestion.
        question.setText("Which keyword creates a subclass in Java?");
        question.addChoice("implements", false);
        question.addChoice("extends", true);
        question.addChoice("inherits", false);

        question.display();        // Inherited method.
        question.displayChoices(); // New subclass method.

        // checkAnswer() is also inherited from Question.
        System.out.println("Answer 2 is correct: "
                + question.checkAnswer("2"));
    }
}

/*
Expected output:
Which keyword creates a subclass in Java?
1: implements
2: extends
3: inherits
Answer 2 is correct: true
*/
