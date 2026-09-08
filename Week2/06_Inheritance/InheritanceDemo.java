// Animal is the superclass (parent class).
class Animal {
    // This field and method belong to the superclass.
    String name;

    void eat() {
        // A superclass method can use a superclass field.
        System.out.println(name + " is eating.");
    }
}

// extends creates an "is-a" relationship: a Lion is an Animal.
// Lion automatically receives name and eat() from Animal.
class Lion extends Animal {
    // A subclass can also add behavior that the superclass does not have.
    void roar() {
        System.out.println(name + " says roar!");
    }
}

public class InheritanceDemo {
    // main() uses a Lion directly so this lesson stays focused on inheritance.
    public static void main(String[] args) {
        // Creating a Lion also creates the inherited Animal portion of the object.
        Lion lion = new Lion();
        // name and eat() are available even though they are not written in Lion.
        lion.name = "Leo";
        lion.eat();
        // roar() is new behavior declared only in Lion.
        lion.roar();
    }
}

/* Expected output:
Leo is eating.
Leo says roar!
*/
