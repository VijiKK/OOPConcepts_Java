// An interface names a capability that otherwise unrelated classes can share.
interface Flyable {
    // The interface declares a contract but does not decide how flying works.
    void fly();
}

// implements means Parrot promises to provide the fly() method.
class Parrot implements Flyable {
    // Interface methods are public, so this implementation must also be public.
    @Override
    public void fly() {
        System.out.println("The parrot flies by flapping its wings.");
    }
}

class Airplane implements Flyable {
    // Airplane fulfills the same contract with a different implementation.
    @Override
    public void fly() {
        System.out.println("The airplane flies using engines.");
    }
}

public class InterfaceDemo {
    // main() creates one object from each implementing class.
    public static void main(String[] args) {
        // These classes are unrelated except that both implement Flyable.
        Parrot parrot = new Parrot();
        Airplane airplane = new Airplane();
        // Both objects have fly(), but each class implements it differently.
        parrot.fly();
        airplane.fly();
    }
}

/* Expected output:
The parrot flies by flapping its wings.
The airplane flies using engines.
*/
