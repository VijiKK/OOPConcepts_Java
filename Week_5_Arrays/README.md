# Week 5: Arrays

These programs follow the array portion of the Week 5 deck and outline. Each
folder contains one independent demonstration with classroom narration and
expected output in the source file.

## Learning sequence

| Folder | Main concept | Source coverage |
| --- | --- | --- |
| `01_Array_Definition` | Same-type elements, cells, and zero-based indices | Slides 1-2 |
| `02_Length_Capacity_Indexing` | `length`, valid bounds, O(1) access, exception | Slide 3 and outline |
| `03_Declaration_Initialization` | Array literal, `new`, and default values | Slides 4-5 |
| `04_Primitive_Reference_Arrays` | Primitive values versus object references | Slide 6 |
| `05_Object_Array_Scoreboard` | `GameEntry[]`, capacity, and logical size | Slides 7-8 |
| `06_Traversal_Search` | Traversal and O(n) unsorted search | Week 5 outline |
| `07_Manual_Insertion` | End, middle, and beginning insertion | Slides 9-10 |
| `08_Manual_Removal` | End, middle, and beginning removal | Slides 11-12 |
| `09_System_Arraycopy` | Block shifting with `System.arraycopy()` | Week 5 outline |
| `10_Dynamic_Resizing` | Resizing with `Arrays.copyOf()` | Week 5 outline |
| `11_Complete_Scoreboard` | Sorted object-array insertion and removal | Slides 7-12 |
| `12_Student_Name_Practice` | Integrated array practice using supplied scenario | Practice document |

## Complexity summary

| Operation | Typical array cost | Reason |
| --- | --- | --- |
| Access a known index | O(1) | Java goes directly to one cell. |
| Search an unsorted array | O(n) | The target may require checking every cell. |
| Insert at the end | O(1) if space exists | No existing element moves. |
| Remove from the end | O(1) | No remaining element moves. |
| Insert or remove near the beginning/middle | O(n) | Existing elements must shift. |
| Resize | O(n) | Elements must be copied into a new array. |

## Compile and run

Run each example from its own folder. For example:

```powershell
cd .\01_Array_Definition
javac .\ArrayDefinitionDemo.java
java ArrayDefinitionDemo
```

Pass the class name to `java`, without `.java` or `.class`.

## Teaching notes

- Distinguish physical **capacity** (`array.length`) from the logical number
  of elements currently in use (`size` or `numEntries`).
- The array's own length never changes. Dynamic resizing creates a new array
  and reassigns the reference.
- `System.arraycopy()` can perform shifting efficiently, but moving many
  elements still has O(n) time complexity.
- Accessing an index below 0 or at least `array.length` causes
  `ArrayIndexOutOfBoundsException`.
- Object-array cells hold references. Unused cells normally contain `null`.

The supplied practice document also introduces `LinkedList`. Folder 12 solves
the array portion first; conversion to and modification through `LinkedList`
belongs with the following linked-list lesson.
