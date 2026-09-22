import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
 * PRACTICE: Complete the supplied Student Name Organizer with LinkedList.
 *
 * Java's java.util.LinkedList is a library implementation of a doubly linked
 * list. This program focuses on using its public methods after the earlier
 * examples explained how nodes and links work internally.
 */
public class StudentNameLinkedListPractice {

    public static boolean startsWithVowel(String name) {
        char first = Character.toLowerCase(name.charAt(0));
        return first == 'a' || first == 'e' || first == 'i'
                || first == 'o' || first == 'u';
    }

    public static void main(String[] args) {
        String[] original = {"Tom", "Alice", "Bob", "Eva", "Mike"};
        System.out.println("Original array: " + Arrays.toString(original));

        // Arrays.asList exposes the array values as a List. The LinkedList
        // constructor copies those values into linked nodes.
        LinkedList<String> students =
                new LinkedList<String>(Arrays.asList(original));

        // Add Zach after the current last node.
        students.addLast("Zach");

        // Human position 2 corresponds to zero-based Java index 1.
        students.add(1, "Grace");

        // Remove the first node and return its element.
        students.removeFirst();

        // remove(Object) searches for and removes the first matching value.
        students.remove("Alice");

        System.out.println("Bob is present: " + students.contains("Bob"));
        System.out.println("Modified LinkedList: " + students);

        // A zero-length argument asks toArray to create an exact-size array.
        String[] finalArray = students.toArray(new String[0]);
        System.out.println("Final array: " + Arrays.toString(finalArray));

        // Optional practice: sort the list alphabetically.
        Collections.sort(students);
        System.out.println("Sorted LinkedList: " + students);

        int vowelCount = 0;
        for (String name : students) {
            if (startsWithVowel(name)) {
                vowelCount++;
            }
        }
        System.out.println("Names beginning with a vowel: " + vowelCount);
    }
}

/*
Expected output:
Original array: [Tom, Alice, Bob, Eva, Mike]
Bob is present: true
Modified LinkedList: [Grace, Bob, Eva, Mike, Zach]
Final array: [Grace, Bob, Eva, Mike, Zach]
Sorted LinkedList: [Bob, Eva, Grace, Mike, Zach]
Names beginning with a vowel: 1
*/
