import java.util.ArrayDeque; // Concrete stack implementation.
import java.util.Deque;      // Interface providing push, pop, and isEmpty.

/*
 * CONCEPT: Nested delimiters and tags close in reverse opening order.
 *
 * Every opening symbol/tag is pushed. A closing symbol/tag must match the most
 * recent opening item at the stack top. A valid input finishes with an empty
 * stack because every opening item has been matched and removed.
 */
public class MatchingDemo {

    /** Returns true when (), {}, and [] are correctly nested and paired. */
    public static boolean delimitersMatch(String expression) {
        String opening = "({["; // Matching positions: 0='(', 1='{', 2='['.
        String closing = ")}]"; // Matching positions: 0=')', 1='}', 2=']'.
        Deque<Character> stack = new ArrayDeque<Character>();

        for (char character : expression.toCharArray()) { // Scan left to right.
            int openingIndex = opening.indexOf(character);
            if (openingIndex != -1) {
                stack.push(character); // Remember this unmatched opener.
            } else {
                int closingIndex = closing.indexOf(character);
                if (closingIndex != -1) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char mostRecentOpening = stack.pop(); // LIFO match candidate.
                    if (opening.indexOf(mostRecentOpening) != closingIndex) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty(); // Any leftover opener makes input invalid.
    }

    /** Returns true when each simple HTML closing tag matches the latest opener. */
    public static boolean htmlTagsMatch(String html) {
        Deque<String> stack = new ArrayDeque<String>();
        int openingBracket = html.indexOf('<'); // Locate the first tag start.

        while (openingBracket != -1) {
            // Locate the end of the current tag.
            int closingBracket = html.indexOf('>', openingBracket + 1);
            if (closingBracket == -1) {
                return false;
            }

            // Remove the angle brackets, leaving h1 or /h1, for example.
            String tag = html.substring(openingBracket + 1, closingBracket);
            if (!tag.startsWith("/")) {
                stack.push(tag); // Save an opening tag for a future closing tag.
            } else {
                String closingName = tag.substring(1);
                if (stack.isEmpty() || !closingName.equals(stack.pop())) {
                    return false;
                }
            }

            // Continue searching after the tag just processed.
            openingBracket = html.indexOf('<', closingBracket + 1);
        }
        return stack.isEmpty();
    }

    /** Runs valid and invalid delimiter and tag examples. */
    public static void main(String[] args) {
        System.out.println("{[( )]} matches: "
                + delimitersMatch("{[( )]}"));
        System.out.println("({[ ])} matches: "
                + delimitersMatch("({[ ])}"));
        System.out.println("Nested HTML matches: "
                + htmlTagsMatch("<body><h1>Title</h1></body>"));
        System.out.println("Crossed HTML matches: "
                + htmlTagsMatch("<body><h1>Title</body></h1>"));
    }
}

/*
Expected output:
{[( )]} matches: true
({[ ])} matches: false
Nested HTML matches: true
Crossed HTML matches: false
*/
