import java.util.Objects;

/*
 * CONCEPT: == compares references; equals() can compare logical contents.
 *
 * Two distinct Stamp objects may contain the same color and value. == still
 * reports false because they are different objects, while the overridden
 * equals() can report true because their contents match.
 */

class Stamp {
    private String color;
    private int value;

    public Stamp(String stampColor, int stampValue) {
        color = stampColor;
        value = stampValue;
    }

    // The parameter must be Object to override Object.equals().
    @Override
    public boolean equals(Object otherObject) {
        // Fast path: both references point to exactly the same object.
        if (this == otherObject) {
            return true;
        }

        // instanceof safely rejects null and objects of unrelated types.
        if (!(otherObject instanceof Stamp)) {
            return false;
        }

        // The check above makes this downcast safe.
        Stamp otherStamp = (Stamp) otherObject;

        return value == otherStamp.value
                && color.equals(otherStamp.color);
    }

    /*
     * Equal objects must have equal hash codes. Objects.hash supplies a simple
     * matching implementation; collections rely on this equals/hashCode rule.
     */
    @Override
    public int hashCode() {
        return Objects.hash(color, value);
    }
}

public class EqualsDemo {

    public static void main(String[] args) {
        Stamp first = new Stamp("blue", 50);
        Stamp second = new Stamp("blue", 50);
        Stamp alias = first;
        Stamp different = new Stamp("red", 50);

        System.out.println("first == second: " + (first == second));
        System.out.println("first.equals(second): "
                + first.equals(second));
        System.out.println("first == alias: " + (first == alias));
        System.out.println("first.equals(different): "
                + first.equals(different));
        System.out.println("Equal objects have equal hash codes: "
                + (first.hashCode() == second.hashCode()));
    }
}

/*
Expected output:
first == second: false
first.equals(second): true
first == alias: true
first.equals(different): false
Equal objects have equal hash codes: true
*/
