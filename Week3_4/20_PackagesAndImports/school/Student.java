// The package statement must match the school directory containing this file.
package school;

// public allows code outside the school package to use Student.
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
