// Animal is the parent class and owns the shared name field.
class Animal {
    String name;

    Animal(String name) {
        // this.name is the field; name is the incoming parameter.
        this.name = name;
        // This message lets us see exactly when the parent constructor runs.
        System.out.println("Animal constructor running");
    }
}

// Lion inherits from Animal but does not inherit Animal's constructor.
class Lion extends Animal {
    Lion(String name) {
        // Constructors are not inherited. super(...) explicitly calls this
        // object's parent constructor and must be the first constructor statement.
        super(name);
        // This statement runs only after the Animal constructor finishes.
        System.out.println("Lion constructor running");
    }
}

public class SuperConstructorDemo {
    public static void main(String[] args) {
        // Creating one Lion runs two constructors: Animal first, then Lion.
        Lion lion = new Lion("Leo");
        // The parent constructor stored the name in the inherited field.
        System.out.println("Lion's name: " + lion.name);
    }
}

/* Expected output:
Animal constructor running
Lion constructor running
Lion's name: Leo
*/
