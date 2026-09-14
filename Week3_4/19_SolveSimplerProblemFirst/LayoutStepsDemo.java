public class LayoutStepsDemo {
    public static void main(String[] args) {
        final int GAP = 10;
        final int MAX_WIDTH = 300;

        // Step 1: place one picture at the origin.
        int firstX = 0;
        int firstWidth = 120;
        int firstHeight = 80;
        System.out.println("Step 1: first picture at (" + firstX + ", 0)");

        // Step 2: the second picture starts after the first picture and a gap.
        int secondX = firstX + firstWidth + GAP;
        int secondWidth = 100;
        System.out.println("Step 2: second picture at (" + secondX + ", 0)");

        // Step 3: test whether the next picture fits before placing it.
        int thirdWidth = 110;
        int thirdX = secondX + secondWidth + GAP;
        if (thirdX + thirdWidth <= MAX_WIDTH) {
            System.out.println("Step 3: third picture at (" + thirdX + ", 0)");
        } else {
            // The next row begins below the first row's height plus the gap.
            int nextRowY = firstHeight + GAP;
            System.out.println("Step 3: third picture at (0, " + nextRowY + ")");
        }

        // Step 4: after the small case works, a loop can generalize the process.
        // In the textbook, these names refer to actual picture files. Here we
        // display the generated names without requiring external image files.
        for (int number = 1; number <= 3; number++) {
            String fileName = "picture" + number + ".jpg";
            System.out.println("Loop name: " + fileName);
        }
    }
}

/* Expected output:
Step 1: first picture at (0, 0)
Step 2: second picture at (130, 0)
Step 3: third picture at (0, 90)
Loop name: picture1.jpg
Loop name: picture2.jpg
Loop name: picture3.jpg
*/
