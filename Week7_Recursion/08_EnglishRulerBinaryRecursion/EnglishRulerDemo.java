/*
 * CONCEPT: Binary recursion makes two recursive calls per non-base case.
 *
 * An interval of length L contains a smaller interval of length L-1, one central
 * tick of length L, and another smaller interval. The two calls form a tree.
 */
public class EnglishRulerDemo {

    static void drawLine(int tickLength, String label) {
        String line = "-".repeat(tickLength); // Create a tick of the requested length.
        System.out.println(line + (label.isEmpty() ? "" : " " + label));
    }

    static void drawInterval(int centralLength) {
        if (centralLength == 0) {
            return; // No smaller tick remains to draw.
        }

        drawInterval(centralLength - 1); // First recursive branch.
        drawLine(centralLength, "");     // Draw this interval's central tick.
        drawInterval(centralLength - 1); // Second recursive branch.
    }

    static void drawRuler(int inches, int majorLength) {
        drawLine(majorLength, "0");

        for (int inch = 1; inch <= inches; inch++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, String.valueOf(inch));
        }
    }

    public static void main(String[] args) {
        drawRuler(2, 3);
        System.out.println("drawInterval makes two calls in each non-base case.");
    }
}
