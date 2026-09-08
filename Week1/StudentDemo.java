public class StudentDemo {

    public static void main(String[] args) {

        Student alice = new Student(
                "Alice", 1001, 80, 75, 80);

        Student bob = new Student(
                "Bob", 1002, 50, 55, 59);

        alice.printSummary();
        bob.printSummary();

        if (alice.averageScore() > bob.averageScore()) {
            System.out.println("Alice has a higher average than Bob.");
        } else if (bob.averageScore() > alice.averageScore()) {
            System.out.println("Bob has a higher average than Alice.");
        } else {
            System.out.println("Alice and Bob have the same average.");
        }
    }
}


// public class StudentDemo {

//     public static void main(String[] args) {

//         Student alice = new Student(
//                 "Alice", 1001, 80, 75, 80);

//         Student bob = new Student(
//                 "Bob", 1002, 50, 55, 59);

//         alice.printSummary();
//         bob.printSummary();

//         if (alice.averageScore() > bob.averageScore()) {
//             System.out.println(
//                     alice.getName() + " has a higher average than " + bob.getName() + ".");
//         } else if (bob.averageScore() > alice.averageScore()) {
//             System.out.println(
//                     bob.getName() + " has a higher average than " + alice.getName() + ".");
//         } else {
//             System.out.println("Both students have the same average.");
//         }
//     }
// }
