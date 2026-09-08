// Flyable is a contract for objects that know how to fly.
interface Flyable {
    // Any class that implements Flyable must provide fly().
    void fly();
}

// Animal is the common superclass for all animals in the zoo.
class Animal {
    // These fields are common to every kind of Animal.
    String name;
    String species;

    Animal(String name, String species) {
        // The Animal constructor initializes the shared part of every subclass.
        this.name = name;
        this.species = species;
    }

    void displayInfo() {
        // The base version displays the two fields shared by all animals.
        System.out.println("Name: " + name + ", Species: " + species);
    }

    void makeSound() {
        // This general behavior is replaced by each specific subclass.
        System.out.println("The animal makes a sound.");
    }
}

class Lion extends Animal {
    // super supplies the Lion's name and fixed species to Animal's constructor.
    Lion(String name) {
        super(name, "Lion");
    }

    // The Lion replaces Animal's general sound with Lion-specific behavior.
    @Override
    void makeSound() {
        System.out.println("Roar!");
    }
}

class Elephant extends Animal {
    Elephant(String name) {
        super(name, "Elephant");
    }

    @Override
    void makeSound() {
        System.out.println("Trumpet!");
    }
}

class Parrot extends Animal implements Flyable {
    // Parrot has both the Animal relationship and the Flyable capability.
    Parrot(String name) {
        super(name, "Parrot");
    }

    @Override
    void displayInfo() {
        // A subclass may override more than one inherited method.
        System.out.println("Name: " + name + ", Species: " + species + " (can fly)");
    }

    @Override
    void makeSound() {
        System.out.println("Squawk!");
    }

    // fly() must be public because it implements an interface method.
    @Override
    public void fly() {
        System.out.println(name + " flies around the zoo.");
    }
}

public class ZooDemo {
    // main() combines constructors, inheritance, overriding, and interfaces.
    public static void main(String[] args) {
        // Widening lets one Animal array hold several subclass objects.
        Animal[] animals = {
            new Lion("Leo"),
            new Elephant("Ella"),
            new Parrot("Polly")
        };

        // Process every animal uniformly through an Animal reference.
        for (Animal animal : animals) {
            // Dynamic dispatch selects methods from Lion, Elephant, or Parrot.
            animal.displayInfo();
            animal.makeSound();
            // Print a blank line to separate one animal from the next.
            System.out.println();
        }

        // The same Parrot object can also be viewed through the Flyable contract.
        Flyable flyingAnimal = new Parrot("Polly");
        // Through Flyable, only behavior promised by that interface is available.
        flyingAnimal.fly();
    }
}

/* Expected output:
Name: Leo, Species: Lion
Roar!

Name: Ella, Species: Elephant
Trumpet!

Name: Polly, Species: Parrot (can fly)
Squawk!

Polly flies around the zoo.
*/
