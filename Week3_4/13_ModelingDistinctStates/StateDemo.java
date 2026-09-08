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
        hunger = NOT_HUNGRY;
        System.out.println(name + " eats and is no longer hungry.");
    }
}

public class StateDemo {
    public static void main(String[] args) {
        Fish fish = new Fish("Finn");
        fish.move();
        fish.move();
        fish.move();
        fish.eat();
    }
}

/* Expected output:
Finn swims around.
Finn swims around.
Finn looks for food.
Finn eats and is no longer hungry.
*/
