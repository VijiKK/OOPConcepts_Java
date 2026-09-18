import java.util.ArrayList;

/*
 * CONCEPT: Put the Question -> ChoiceQuestion story together.
 *
 * This is the complete version of the example developed in the slides:
 * inheritance, private superclass data, an added list and method, overriding,
 * super.display(), and inherited answer checking.
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

    public boolean checkAnswer(String response) {
        return answer.equals(response);
    }

    public void display() {
        System.out.println(text);
    }
}

class ChoiceQuestion extends Question {
    private ArrayList<String> choices = new ArrayList<String>();

    public void addChoice(String choice, boolean correct) {
        choices.add(choice);

        if (correct) {
            // size() is the one-based number of the choice just added.
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

public class ChoiceQuestionDemo {

    public static void main(String[] args) {
        ChoiceQuestion question = new ChoiceQuestion();
        question.setText("In which country was Java invented?");
        question.addChoice("Australia", false);
        question.addChoice("Canada", true);
        question.addChoice("Denmark", false);
        question.addChoice("United States", false);

        question.display();

        String studentResponse = "2";
        System.out.println("Student answered: " + studentResponse);
        System.out.println("Correct: "
                + question.checkAnswer(studentResponse));
    }
}

/*
Expected output:
In which country was Java invented?
1: Australia
2: Canada
3: Denmark
4: United States
Student answered: 2
Correct: true
*/
