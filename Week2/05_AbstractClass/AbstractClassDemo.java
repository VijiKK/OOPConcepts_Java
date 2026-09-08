// abstract means Animal is an incomplete general blueprint for its subclasses.
abstract class Animal {
    // Subclasses inherit this common field.
    String name;

    Animal(String name) {
        // Save the parameter in this object's inherited name field.
        this.name = name;
    }

    // An abstract class may contain a normal, fully implemented method.
    void displayName() {
        System.out.println("Name: " + name);
    }

    // An abstract method has no body; each concrete subclass must implement it.
    abstract void makeSound();
}

class Lion extends Animal {
    Lion(String name) {
        // Initialize the Animal part of this Lion.
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Roar!");
    }
}

class Elephant extends Animal {
    Elephant(String name) {
        // Every subclass constructor must initialize its Animal portion.
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Trumpet!");
    }
}

public class AbstractClassDemo {
    // main() creates concrete subclasses because Animal itself is incomplete.
    public static void main(String[] args) {
        // Animal animal = new Animal("Alex"); // Error: an abstract class cannot be instantiated.
        // Concrete subclasses can be instantiated.
        Lion lion = new Lion("Leo");
        Elephant elephant = new Elephant("Ella");
        // displayName() is inherited; makeSound() is supplied by each subclass.
        lion.displayName();
        lion.makeSound();
        elephant.displayName();
        elephant.makeSound();
    }
}

/* Expected output:
Name: Leo
Roar!
Name: Ella
Trumpet!
*/
