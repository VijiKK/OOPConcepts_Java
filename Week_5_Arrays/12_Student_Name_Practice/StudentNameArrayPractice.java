import java.util.Arrays;

/*
 * PRACTICE: Student Name Organizer using arrays only.
 *
 * The supplied practice continues by converting to LinkedList. This version
 * deliberately completes the same modifications with an array, reinforcing
 * capacity, logical size, insertion, removal, search, and conversion to an
 * exact-length result. LinkedList can later solve the same problem differently.
 */
public class StudentNameArrayPractice {

    public static int insert(String[] data, int size,
            int index, String value) {
        if (size == data.length) {
            throw new IllegalStateException("No unused array cell remains.");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        return size + 1;
    }

    public static int findIndex(String[] data, int size, String target) {
        for (int index = 0; index < size; index++) {
            if (data[index].equals(target)) {
                return index;
            }
        }
        return -1;
    }

    public static int removeAt(String[] data, int size, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        System.arraycopy(data, index + 1,
                data, index, size - index - 1);
        data[size - 1] = null;
        return size - 1;
    }

    public static boolean startsWithVowel(String name) {
        char first = Character.toLowerCase(name.charAt(0));
        return first == 'a' || first == 'e' || first == 'i'
                || first == 'o' || first == 'u';
    }

    public static void main(String[] args) {
        String[] original = {"Tom", "Alice", "Bob", "Eva", "Mike"};
        System.out.println("Original array: " + Arrays.toString(original));

        // Reserve extra capacity because the original array itself is full.
        String[] working = Arrays.copyOf(original, 8);
        int size = original.length;

        // Add Zach to the end. No shifting is required.
        size = insert(working, size, size, "Zach");

        // "Position 2" means the second human position, which is Java index 1.
        size = insert(working, size, 1, "Grace");

        // Remove the first student at index 0.
        size = removeAt(working, size, 0);

        // Search for Alice before removing her by name.
        int aliceIndex = findIndex(working, size, "Alice");
        if (aliceIndex != -1) {
            size = removeAt(working, size, aliceIndex);
        }

        System.out.println("Bob is present: "
                + (findIndex(working, size, "Bob") != -1));

        // Convert the capacity array into an exact-length final array.
        String[] finalNames = Arrays.copyOf(working, size);
        System.out.println("Final array: " + Arrays.toString(finalNames));

        // Optional practice: sort alphabetically.
        Arrays.sort(finalNames);
        System.out.println("Sorted final array: "
                + Arrays.toString(finalNames));

        int vowelCount = 0;
        for (String name : finalNames) {
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
Final array: [Grace, Bob, Eva, Mike, Zach]
Sorted final array: [Bob, Eva, Grace, Mike, Zach]
Names beginning with a vowel: 1
*/
