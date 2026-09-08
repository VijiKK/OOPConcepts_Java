// Progression contains the state and printing algorithm shared by all sequences.
class Progression {
    // protected allows this class and its subclasses to use current.
    protected long current;

    Progression(long start) {
        // Store the first value of the progression.
        current = start;
    }

    // Subclasses override this method to define how their sequence advances.
    protected long nextValue() {
        return current;
    }

    // All progressions reuse the same loop and printing code.
    void printProgression(int count) {
        // Repeat exactly count times; i identifies the current output position.
        for (int i = 0; i < count; i++) {
            // Dynamic dispatch chooses nextValue() for the actual object.
            System.out.print(nextValue());
            // Print spaces between values, but not after the final value.
            if (i < count - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); // Finish the progression with a newline.
    }
}

class ArithmeticProgression extends Progression {
    // This amount is added to produce each new term.
    private long increment;

    ArithmeticProgression(long start, long increment) {
        // Initialize the inherited current field with the starting value.
        super(start);
        this.increment = increment;
    }

    @Override
    protected long nextValue() {
        // Return the current term, then prepare the following term by addition.
        long answer = current;
        current = current + increment;
        return answer;
    }
}

class GeometricProgression extends Progression {
    // This factor is multiplied to produce each new term.
    private long base;

    GeometricProgression(long start, long base) {
        super(start);
        this.base = base;
    }

    @Override
    protected long nextValue() {
        // Geometric progression changes the inherited behavior to multiplication.
        long answer = current;
        current = current * base;
        return answer;
    }
}

class FibonacciProgression extends Progression {
    // Fibonacci needs both the current and previous terms.
    private long previous = 1;

    FibonacciProgression() {
        // The Fibonacci sequence in this example begins at 0.
        super(0);
    }

    @Override
    protected long nextValue() {
        // Save the term to return before updating the two-term state.
        long answer = current;
        long next = previous + current;
        // Shift both stored terms forward for the following call.
        previous = current;
        current = next;
        return answer;
    }
}

public class ProgressionDemo {
    // main() treats several subclass objects uniformly as Progression objects.
    public static void main(String[] args) {
        // Each variable has the same reference type but a different actual type.
        Progression arithmetic = new ArithmeticProgression(2, 3);
        Progression geometric = new GeometricProgression(2, 3);
        Progression fibonacci = new FibonacciProgression();

        // printProgression() is reused; its call to nextValue() is dynamically dispatched.
        System.out.println("Arithmetic:");
        arithmetic.printProgression(5);
        System.out.println("Geometric:");
        geometric.printProgression(5);
        System.out.println("Fibonacci:");
        fibonacci.printProgression(7);
    }
}

/* Expected output:
Arithmetic:
2 5 8 11 14
Geometric:
2 6 18 54 162
Fibonacci:
0 1 1 2 3 5 8
*/
