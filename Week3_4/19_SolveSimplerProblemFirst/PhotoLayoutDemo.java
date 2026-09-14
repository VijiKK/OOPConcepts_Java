class Photo {
    private String name;
    private int width;
    private int height;
    private int x;
    private int y;

    Photo(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getRightEdge() {
        return x + width;
    }

    int getBottomEdge() {
        return y + height;
    }

    int getWidth() {
        return width;
    }

    void displayPosition() {
        System.out.println(name + " at (" + x + ", " + y + ")");
    }
}

public class PhotoLayoutDemo {
    private static final int MAX_WIDTH = 300;
    private static final int GAP = 10;

    public static void main(String[] args) {
        // First solve the small problem: describe the photos to arrange.
        Photo[] photos = {
            new Photo("Photo 1", 120, 80),
            new Photo("Photo 2", 100, 60),
            new Photo("Photo 3", 110, 70),
            new Photo("Photo 4", 90, 50),
            new Photo("Photo 5", 140, 40)
        };

        // Place the first photo at the top-left corner.
        photos[0].moveTo(0, 0);
        // currentX is the next available horizontal position in the current row.
        int nextX = photos[0].getRightEdge() + GAP;
        // currentRowY keeps every photo in one row at the same vertical position.
        int currentRowY = 0;
        // rowBottom remembers the lowest edge reached by all completed content.
        int rowBottom = photos[0].getBottomEdge();

        // Then extend the working idea to every remaining photo.
        for (int index = 1; index < photos.length; index++) {
            Photo photo = photos[index];

            // Keep the photo on this row only when its right edge will fit.
            if (nextX + photo.getWidth() <= MAX_WIDTH) {
                photo.moveTo(nextX, currentRowY);
            } else {
                // Otherwise, begin a new row below the tallest first-row photo.
                currentRowY = rowBottom + GAP;
                photo.moveTo(0, currentRowY);
            }

            // Prepare the horizontal position for the next photo.
            nextX = photo.getRightEdge() + GAP;
            // Remember the lowest edge so a later row will not overlap this one.
            rowBottom = Math.max(rowBottom, photo.getBottomEdge());
        }

        for (Photo photo : photos) {
            photo.displayPosition();
        }
    }
}

/* Expected output:
Photo 1 at (0, 0)
Photo 2 at (130, 0)
Photo 3 at (0, 90)
Photo 4 at (120, 90)
Photo 5 at (0, 170)
*/
