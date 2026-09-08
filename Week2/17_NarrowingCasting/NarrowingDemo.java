// Animal is the general parent type used for both object references.
class Animal {
    String name;

    Animal(String name) {
        // All subclasses reuse this constructor to initialize name.
        this.name = name;
    }
}

class Lion extends Animal {
    Lion(String name) {
        super(name);
    }

    // roar() exists only in Lion, not in the general Animal class.
    void roar() {
        System.out.println(name + " says roar!");
    }
}

class Elephant extends Animal {
    Elephant(String name) {
        super(name);
    }
}

public class NarrowingDemo {
    // main() shows both a checked cast and an intentionally invalid cast.
    public static void main(String[] args) {
        // The reference type is Animal, but the actual object is Lion.
        Animal animal = new Lion("Leo");

        // Animal -> Lion, or general -> specific, requires an explicit cast.
        // instanceof checks the actual object type before the cast is attempted.
        if (animal instanceof Lion) {
            Lion lion = (Lion) animal;
            // After narrowing, Lion-specific methods are available.
            lion.roar();
        }

        // This second Animal reference actually points to an Elephant.
        Animal animal2 = new Elephant("Ella");
        try {
            // This compiles because Animal could refer to a Lion, but it fails at
            // runtime because this particular object is actually an Elephant.
            Lion wrongLion = (Lion) animal2;
            wrongLion.roar();
        } catch (ClassCastException exception) {
            // Catching the exception keeps this classroom demonstration running.
            System.out.println("ClassCastException prevented the invalid cast.");
        }
    }
}

/* Expected output:
Leo says roar!
ClassCastException prevented the invalid cast.
*/
