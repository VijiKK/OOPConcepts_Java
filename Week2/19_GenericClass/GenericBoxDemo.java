// <T> makes Box a generic class rather than a class for one fixed item type.
class Box<T> {
    // T is a placeholder for the type chosen when a Box object is declared.
    private T item;

    // setItem() stores a value of the selected type.
    void setItem(T item) {
        // The parameter must have the same chosen type as this Box.
        this.item = item;
    }

    // getItem() returns a value of the selected type.
    T getItem() {
        // The return type is also the type chosen for this Box.
        return item;
    }
}

public class GenericBoxDemo {
    // main() reuses the same Box class with two concrete types.
    public static void main(String[] args) {
        // For wordBox, every T in Box is treated as String.
        Box<String> wordBox = new Box<String>();
        // Only String values can be placed in wordBox.
        wordBox.setItem("Hello");

        // For numberBox, every T in Box is treated as Integer.
        Box<Integer> numberBox = new Box<Integer>();
        // Only Integer values can be placed in numberBox.
        numberBox.setItem(42);

        // No cast is needed because getItem() has the correct concrete return type.
        System.out.println("Word: " + wordBox.getItem());
        System.out.println("Number: " + numberBox.getItem());
    }
}

/* Expected output:
Word: Hello
Number: 42
*/
