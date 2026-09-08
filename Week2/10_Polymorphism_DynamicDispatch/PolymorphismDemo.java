// Animal supplies the common reference type and shared method declaration.
class Animal {
    String name;

    Animal(String name) {
        // Every subclass object receives this inherited state.
        this.name = name;
    }

    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Lion extends Animal {
    // Pass the name to the parent constructor.
    Lion(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Roar!");
    }
}

class Elephant extends Animal {
    Elephant(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Trumpet!");
    }
}

class Parrot extends Animal {
    Parrot(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Squawk!");
    }
}

public class PolymorphismDemo {
    // main() demonstrates dynamic method dispatch through Animal references.
    public static void main(String[] args) {
        // Reference type = Animal. Actual object type = Lion.
        // The Animal reference can call methods declared by Animal.
        Animal a = new Lion("Leo");
        // At runtime, Java finds the Lion version of makeSound().
        a.makeSound();

        // One Animal array can hold objects from several Animal subclasses.
        Animal[] animals = {
            // Each child object is automatically widened to Animal.
            new Lion("Leo"),
            new Elephant("Ella"),
            new Parrot("Polly")
        };

        System.out.println("Animal array:");
        // The enhanced for loop visits each Animal reference in the array.
        for (Animal animal : animals) {
            // The reference type is Animal on every loop iteration.
            // The actual object type changes, so the selected method changes.
            animal.makeSound();
        }

        // Java selects the overridden method using the actual object at runtime.
        // Same method call, different object, different behavior.
    }
}

/* Expected output:
Roar!
Animal array:
Roar!
Trumpet!
Squawk!
*/
