/*
 * CONCEPT: Build and test the general Question superclass first.
 *
 * Question stores the common state and behavior that all future question
 * types will share: question text, an answer, display, and answer checking.
 */

class Question {
    // private keeps the data encapsulated inside Question.
    private String text;
    private String answer;

    // Set the text that will be shown to the student.
    public void setText(String questionText) {
        text = questionText;
    }

    // Set the answer used by checkAnswer().
    public void setAnswer(String correctAnswer) {
        answer = correctAnswer;
    }

    // Display the question. A later subclass will override this method.
    public void display() {
        System.out.println(text);
    }

    // Return true when the student's response matches the stored answer.
    public boolean checkAnswer(String response) {
        return answer.equals(response);
    }
}

public class QuestionDemo {

    public static void main(String[] args) {
        Question question = new Question();

        // Configure the object through its public methods.
        question.setText("Who was the inventor of Java?");
        question.setAnswer("James Gosling");

        question.display();
        System.out.println("James Gosling: "
                + question.checkAnswer("James Gosling"));
        System.out.println("Alan Turing: "
                + question.checkAnswer("Alan Turing"));
    }
}

/*
Expected output:
Who was the inventor of Java?
James Gosling: true
Alan Turing: false
*/
