import java.util.ArrayList;

class Question {
    private String prompt;
    // One Question object contains a collection of String objects.
    private ArrayList<String> choices;

    Question(String prompt) {
        this.prompt = prompt;
        // Construct an empty list before addChoice() can use it.
        choices = new ArrayList<String>();
    }

    void addChoice(String choice) {
        // Each call adds another String to the same ArrayList object.
        choices.add(choice);
    }

    int getChoiceCount() {
        // size() reports how many elements the list currently contains.
        return choices.size();
    }

    void display() {
        System.out.println(prompt);

        // Display list positions as classroom-friendly numbers beginning with 1.
        for (int index = 0; index < choices.size(); index++) {
            System.out.println((index + 1) + ". " + choices.get(index));
        }
    }
}

public class CollectingValuesDemo {
    public static void main(String[] args) {
        Question question = new Question("Which keyword creates an object?");
        question.addChoice("class");
        question.addChoice("new");
        question.addChoice("void");
        question.display();
        // This directly answers: "If addChoice() is called three times, how many items?"
        System.out.println("Number of choices: " + question.getChoiceCount());
    }
}

/* Expected output:
Which keyword creates an object?
1. class
2. new
3. void
Number of choices: 3
*/
