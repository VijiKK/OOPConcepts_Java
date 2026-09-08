class Thermostat {
    private double temperature;

    Thermostat(double temperature) {
        this.temperature = temperature;
    }

    // An accessor observes state without changing it.
    double getTemperature() {
        return temperature;
    }

    // A mutator changes the state of this object.
    void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

public class AccessorMutatorDemo {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat(70.0);

        System.out.println("Before: " + thermostat.getTemperature());
        thermostat.setTemperature(72.0);
        System.out.println("After: " + thermostat.getTemperature());
    }
}

/* Expected output:
Before: 70.0
After: 72.0
*/
