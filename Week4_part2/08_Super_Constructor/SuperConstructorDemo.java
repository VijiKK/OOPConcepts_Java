import java.util.ArrayList;

/*
 * CONCEPT: A subclass constructor initializes the superclass portion first.
 *
 * super(...) calls a superclass constructor. When used, it must be the first
 * statement in the subclass constructor because the parent part of the object
 * must exist before the child adds its own state.
 */

class Question {
    private String text;
    private String answer;

    public Question(String questionText, String correctAnswer) {
        text = questionText;
        answer = correctAnswer;
        System.out.println("1. Question constructor finished.");
    }

    public void display() {
        System.out.println(text);
    }

    public boolean checkAnswer(String response) {
        return answer.equals(response);
    }
}

class ChoiceQuestion extends Question {
    private ArrayList<String> choices;

    public ChoiceQuestion(String questionText, String correctAnswer) {
        // This must be first. It calls Question(String, String).
        super(questionText, correctAnswer);

        // Now initialize the state introduced by ChoiceQuestion.
        choices = new ArrayList<String>();
        System.out.println("2. ChoiceQuestion constructor finished.");
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }

    @Override
    public void display() {
        super.display();
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ": " + choices.get(i));
        }
    }
}

public class SuperConstructorDemo {

    public static void main(String[] args) {
        ChoiceQuestion question = new ChoiceQuestion(
                "Which call initializes the superclass?", "2");
        question.addChoice("this(...)");
        question.addChoice("super(...)");

        question.display();
        System.out.println("Answer 2 is correct: "
                + question.checkAnswer("2"));
    }
}

/*
 * If a constructor omits super(...), Java inserts super() automatically.
 * That works only when the superclass has an accessible no-argument
 * constructor.
 *
Expected output:
1. Question constructor finished.
2. ChoiceQuestion constructor finished.
Which call initializes the superclass?
1: this(...)
2: super(...)
Answer 2 is correct: true
*/
