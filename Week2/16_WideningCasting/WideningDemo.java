// Animal is the general parent type used as the widening destination.
class Animal {
    // This field is inherited by Lion.
    String name;

    Animal(String name) {
        // Store the supplied name in the new object's field.
        this.name = name;
    }

    void displayName() {
        // This method is available through both Lion and Animal references.
        System.out.println("Animal name: " + name);
    }
}

// Lion is a more specific kind of Animal.
class Lion extends Animal {
    Lion(String name) {
        // Initialize the inherited Animal state.
        super(name);
    }
}

public class WideningDemo {
    // main() demonstrates a safe, automatic reference conversion.
    public static void main(String[] args) {
        // The variable and actual object are initially both Lion.
        Lion lion = new Lion("Leo");

        // Lion -> Animal, child -> parent, specific -> general.
        // Widening is automatic, so no explicit cast is required.
        Animal animal = lion;
        // Through an Animal reference, we use members known to the Animal type.
        animal.displayName();
    }
}

/* Expected output:
Animal name: Leo
*/
