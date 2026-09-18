/*
 * CONCEPT: A subclass does not directly access private superclass fields.
 *
 * Inheritance gives ChoiceQuestion access to Question's public interface,
 * but Question still owns and protects its private answer field.
 */

class Question {
    private String answer;

    public void setAnswer(String correctAnswer) {
        answer = correctAnswer;
    }

    public boolean checkAnswer(String response) {
        return answer.equals(response);
    }
}

class ChoiceQuestion extends Question {

    public void chooseCorrectAnswer(String choiceNumber) {
        // Correct: ask the superclass object to update its private data.
        setAnswer(choiceNumber);

        // WRONG (leave commented): answer is private in Question.
        // answer = choiceNumber;
    }

    /*
     * Also wrong: declaring another field named answer here would create a
     * separate field. It would not update Question's private answer, so the
     * inherited checkAnswer() method would still read Question's field.
     *
     * private String answer; // Do not duplicate inherited state.
     */
}

public class PrivateAccessDemo {

    public static void main(String[] args) {
        ChoiceQuestion question = new ChoiceQuestion();
        question.chooseCorrectAnswer("2");

        System.out.println("Answer 2 is correct: "
                + question.checkAnswer("2"));
    }
}

/*
Expected output:
Answer 2 is correct: true
*/
