import java.util.ArrayList; // Holds each directory's child entries.
import java.util.List;      // General collection interface.

/*
 * PRACTICE: A file system is a general tree. Postorder computes directory size
 * because each child's size must be known before calculating its parent total.
 */
public class FileSystemTreeDemo {
    private static class Entry {
        private String name;          // File or directory name.
        private int ownKilobytes;     // File size; directories use zero.
        private List<Entry> children; // Empty for a file.

        public Entry(String entryName, int kilobytes) {
            name = entryName;                      // Save display name.
            ownKilobytes = kilobytes;              // Save this entry's own size.
            children = new ArrayList<Entry>();     // Begin with no children.
        }

        /** Links a file/directory directly below this directory. */
        public Entry add(Entry child) {
            children.add(child); // Store a reference to the existing child.
            return child;
        }
    }

    /** Computes and prints subtree size after recursively computing children. */
    private static int computeSizePostorder(Entry entry) {
        int total = entry.ownKilobytes; // Start with file's own size or zero.
        for (Entry child : entry.children) {
            total += computeSizePostorder(child); // Add completed child subtree.
        }
        System.out.println(entry.name + ": " + total + " KB"); // Visit last.
        return total; // Parent call receives this entire subtree's size.
    }

    /** Builds a small directory hierarchy and totals it bottom-up. */
    public static void main(String[] args) {
        Entry root = new Entry("cs16/", 0);              // Root directory.
        Entry homework = root.add(new Entry("homeworks/", 0));
        homework.add(new Entry("h1.doc", 3));            // Leaf file.
        homework.add(new Entry("h2.doc", 2));
        Entry programs = root.add(new Entry("programs/", 0));
        programs.add(new Entry("Robot.java", 20));
        root.add(new Entry("todo.txt", 1));

        computeSizePostorder(root); // Children print before their directories.
    }
}

/* Expected output:
h1.doc: 3 KB
h2.doc: 2 KB
homeworks/: 5 KB
Robot.java: 20 KB
programs/: 20 KB
todo.txt: 1 KB
cs16/: 26 KB
*/
