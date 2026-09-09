class Fish {
    // Named constants make state values meaningful and prevent magic numbers.
    static final int NOT_HUNGRY = 0;
    static final int SOMEWHAT_HUNGRY = 1;
    static final int VERY_HUNGRY = 2;

    private String name;
    private int hunger = NOT_HUNGRY;

    Fish(String name) {
        this.name = name;
    }

    void move() {
        // Behavior depends on the object's state before movement.
        if (hunger == VERY_HUNGRY) {
            System.out.println(name + " looks for food.");
        } else {
            System.out.println(name + " swims around.");
            hunger++;
        }
    }

    void eat() {
        // Eating changes the state back to the named starting state.
        hunger = NOT_HUNGRY;
        System.out.println(name + " eats and is no longer hungry.");
    }

    void displayState() {
        // Convert the numeric state into a meaningful label for visible output.
        if (hunger == NOT_HUNGRY) {
            System.out.println("Current state: NOT_HUNGRY");
        } else if (hunger == SOMEWHAT_HUNGRY) {
            System.out.println("Current state: SOMEWHAT_HUNGRY");
        } else {
            System.out.println("Current state: VERY_HUNGRY");
        }
    }
}

public class StateDemo {
    public static void main(String[] args) {
        Fish fish = new Fish("Finn");
        fish.displayState();
        fish.move();
        fish.displayState();
        fish.move();
        fish.displayState();
        fish.move();
        fish.eat();
        fish.displayState();
    }
}

/* Expected output:
Current state: NOT_HUNGRY
Finn swims around.
Current state: SOMEWHAT_HUNGRY
Finn swims around.
Current state: VERY_HUNGRY
Finn looks for food.
Finn eats and is no longer hungry.
Current state: NOT_HUNGRY
*/
