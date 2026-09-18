/*
 * CONCEPTS: Code reuse and the substitution principle.
 *
 * Car and Bus reuse the fields and methods in Vehicle. Because each subclass
 * "is a" Vehicle, either object can be supplied to a method that expects a
 * Vehicle. Overriding is saved for a later example.
 */

class Vehicle {
    // protected permits subclasses to use this field directly.
    // Later examples explain why private fields are usually preferred.
    protected String name;

    public void setName(String vehicleName) {
        name = vehicleName;
    }

    public void move() {
        System.out.println(name + " moves using Vehicle's reusable method.");
    }
}

// These subclasses need no copy of setName() or move().
class Car extends Vehicle {
}

class Bus extends Vehicle {
}

public class SubstitutionDemo {

    // The parameter type is the general superclass type.
    public static void startTrip(Vehicle vehicle) {
        vehicle.move();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setName("Car");

        Bus bus = new Bus();
        bus.setName("Bus");

        // Substitution: a Car or Bus can stand in for a Vehicle.
        startTrip(car);
        startTrip(bus);
    }
}

/*
Expected output:
Car moves using Vehicle's reusable method.
Bus moves using Vehicle's reusable method.
*/
