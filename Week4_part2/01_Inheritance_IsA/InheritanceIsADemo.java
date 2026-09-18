/*
 * CONCEPT: Inheritance models an "is-a" relationship.
 *
 * A Car is a Vehicle, so Car can inherit useful behavior from Vehicle.
 * This first example intentionally does not use overriding or polymorphism.
 * It introduces only the basic superclass/subclass relationship.
 */

// Vehicle is the superclass (also called the parent or base class).
class Vehicle {

    // This behavior is available to Vehicle and is inherited by Car.
    public void move() {
        System.out.println("The vehicle is moving, printing from parent class.");
    }
}

// The extends keyword says: "Car is a specialized kind of Vehicle."
class Car extends Vehicle {

    // A subclass can add behavior that does not exist in the superclass.
    public void openTrunk() {
        System.out.println("The car's trunk is open.");
    }
}

// This public class name matches the file name.
public class InheritanceIsADemo {

    public static void main(String[] args) {
        // A Vehicle object can use behavior declared in Vehicle.
        Vehicle vehicle = new Vehicle();
        vehicle.move();

        // A Car object can use both inherited and newly added behavior.
        Car car = new Car();
        car.move();       // Inherited from Vehicle; Car did not rewrite it.
        car.openTrunk();  // Declared specifically in Car.
    }
}

/*
Expected output:
The vehicle is moving.
The vehicle is moving.
The car's trunk is open.
*/
