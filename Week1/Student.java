public class Student {

    private String name;
    private int id;
    private double score1;
    private double score2;
    private double score3;

    public Student(String name, int id,
                   double score1, double score2, double score3) {
        this.name = name;
        this.id = id;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public double averageScore() {
        return (score1 + score2 + score3) / 3.0;
    }

    public boolean isPassing() {
        return averageScore() >= 60;
    }

    public void printSummary() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("Average Score: %.2f%n", averageScore());

        if (isPassing()) {
            System.out.println("Status: Pass");
        } else {
            System.out.println("Status: Fail");
        }

        System.out.println();
    }
}