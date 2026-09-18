/*
 * CONCEPTS: Overriding versus overloading and common inheritance mistakes.
 *
 * - Override: same method signature in a subclass.
 * - Overload: same method name with different parameters.
 * - Use super.method() when the subclass needs the parent implementation.
 * - A final method cannot be overridden.
 * - A Java class can directly extend only one class.
 */

class Employee {
    private double salary;
    private int employeeId;

    public Employee(double employeeSalary, int id) {
        salary = employeeSalary;
        employeeId = id;
    }

    public double getSalary() {
        return salary;
    }

    // final allows inheritance of this method but prevents overriding it.
    public final int getEmployeeId() {
        return employeeId;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(double salary, double managerBonus, int id) {
        super(salary, id);
        bonus = managerBonus;
    }

    // Exact same signature as Employee.getSalary(): this is overriding.
    @Override
    public double getSalary() {
        // Correct: reuse the superclass method, then add the bonus.
        return super.getSalary() + bonus;

        // WRONG: return getSalary() + bonus;
        // That calls this same method repeatedly and causes infinite recursion.
    }

    // Different parameter list: this is overloading, not overriding.
    public double getSalary(double taxRate) {
        return getSalary() * (1 - taxRate);
    }

    // WRONG (leave commented): final methods cannot be overridden.
    // public int getEmployeeId() { return 999; }
}

public class InheritanceMistakesDemo {

    public static void main(String[] args) {
        Employee employee = new Employee(50000, 101);
        Manager manager = new Manager(70000, 10000, 202);

        System.out.println("Employee salary: " + employee.getSalary());
        System.out.println("Manager salary: " + manager.getSalary());
        System.out.println("Manager after 10% tax: "
                + manager.getSalary(0.10));
        System.out.println("Inherited final ID: "
                + manager.getEmployeeId());
    }
}

/*
 * Java supports one direct superclass:
 *     class Manager extends Employee { ... }
 * It does not permit:
 *     class Manager extends Employee, Person { ... }
 * A class can implement multiple interfaces, which is a later distinction.
 *
Expected output:
Employee salary: 50000.0
Manager salary: 80000.0
Manager after 10% tax: 72000.0
Inherited final ID: 202
*/
