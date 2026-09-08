// Animal defines the original method that subclasses override.
class Animal {
    // The parent supplies behavior that subclasses may replace.
    void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

class Lion extends Animal {
    // @Override asks Java to verify that this matches an inherited method.
    @Override
    void makeSound() {
        System.out.println("The lion says roar!");
    }
}

class Elephant extends Animal {
    // The name, parameter list, and return type match the parent method.
    @Override
    void makeSound() {
        System.out.println("The elephant says trumpet!");
    }
}

public class MethodOverridingDemo {
    // Exact class types are used here so the lesson focuses only on overriding.
    public static void main(String[] args) {
        // Each variable refers to an object of the same declared type.
        Animal animal = new Animal();
        Lion lion = new Lion();
        Elephant elephant = new Elephant();
        // The calls look the same, but each class supplies its own implementation.
        animal.makeSound();
        lion.makeSound();
        elephant.makeSound();
    }
}

/*
Overloading: same method name, different parameters.
Overriding: same method signature in parent and child, new child implementation.

Expected output:
The animal makes a sound.
The lion says roar!
The elephant says trumpet!
*/
