import java.util.ArrayList;

/*
 * CONCEPT: A superclass parameter can process different subclass objects.
 *
 * presentQuestion() is written once for Question. The substitution principle
 * lets us pass a Question or any subclass object, such as ChoiceQuestion.
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

class ChoiceQuestion extends Question {
    private ArrayList<String> choices = new ArrayList<String>();

    public void addChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {
            setAnswer(Integer.toString(choices.size()));
        }
    }

    @Override
    public void display() {
        super.display();
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ": " + choices.get(i));
        }
    }
}

public class PolymorphismDemo {

    // This method knows only the Question interface it needs.
    public static void presentQuestion(Question question, String response) {
        question.display();
        System.out.println("Response: " + response);
        System.out.println("Correct: " + question.checkAnswer(response));
        System.out.println();
    }

    public static void main(String[] args) {
        Question plainQuestion = new Question();
        plainQuestion.setText("Who invented Java?");
        plainQuestion.setAnswer("James Gosling");

        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setText("Which keyword creates a subclass?");
        choiceQuestion.addChoice("extends", true);
        choiceQuestion.addChoice("imports", false);

        presentQuestion(plainQuestion, "James Gosling");

        // A ChoiceQuestion is accepted where Question is required.
        presentQuestion(choiceQuestion, "1");
    }
}

/*
Expected output:
Who invented Java?
Response: James Gosling
Correct: true

Which keyword creates a subclass?
1: extends
2: imports
Response: 1
Correct: true

*/
