# Week 5: Linked Lists

These programs follow slides 13-30 of the Week 5 array and linked-list deck.
Each folder introduces one structural idea or operation and contains detailed
comments plus expected output for classroom use.

## Learning sequence

| Folder | Main concept | Original slides |
| --- | --- | --- |
| `01_Why_Linked_Lists` | Nodes, links, `head`, and `null` | 13-14 |
| `02_Singly_Structure_Accessors` | `Node<E>`, head, tail, size, and accessors | 15-16 |
| `03_Singly_AddFirst` | Link a new node before the old head | 17 and 19 |
| `04_Singly_AddLast` | Use tail to append in O(1) | 18 and 19 |
| `05_Singly_RemoveFirst` | Advance head and handle empty/single-node cases | 20-21 |
| `06_Singly_RemoveLast` | Forward traversal to find the previous node | 22 |
| `07_Complete_Singly_List` | Complete generic singly linked list | 15-22 |
| `08_Doubly_Basic_Structure` | `previous`, element, `next`, two-way traversal | 23-24 |
| `09_Doubly_Insertion` | Sentinel nodes and reconnecting neighbors | 25, 27-30 |
| `10_Doubly_Deletion` | Bypass a known node in O(1) | 26, 27-30 |
| `11_Complete_Doubly_List` | Complete generic doubly linked list | 27-30 |
| `12_Singly_Doubly_Comparison` | Links, traversal, and memory tradeoff | Recap |
| `13_Java_LinkedList_Practice` | Student organizer using the Java library | Practice |

## Complexity comparison

The table assumes that the singly linked list keeps a tail reference.

| Operation | Singly linked | Doubly linked | Explanation |
| --- | --- | --- | --- |
| `first()` / `last()` | O(1) | O(1) | The list stores head/tail references. |
| `addFirst()` | O(1) | O(1) | Only a fixed number of links change. |
| `addLast()` | O(1) | O(1) | The stored tail gives direct access. |
| `removeFirst()` | O(1) | O(1) | Move the first reference forward. |
| `removeLast()` | O(n) | O(1) | A singly node has no backward link. |
| Search by value | O(n) | O(n) | Either list may need to inspect every node. |

## Compile and run

Run each demonstration from its own folder:

```powershell
cd .\01_Why_Linked_Lists
javac .\LinkedStructureDemo.java
java LinkedStructureDemo
```

Pass the class name to `java`, without `.java` or `.class`.

## Teaching notes

- A linked list grows by allocating nodes. It does not resize one continuous
  array and does not shift all later elements for front insertion/removal.
- Generic `Node<E>` lets the same implementation store different element
  types while preserving compile-time type safety.
- Empty and one-node lists need special attention because `head` and `tail`
  may both change.
- Singly linked nodes know only their successor. This is why removing the last
  node requires a walk from `head` to find the predecessor.
- Doubly linked nodes spend an extra reference per node to support backward
  movement and direct reconnection of both neighbors.
- Header and trailer sentinels contain no user data. They simplify boundary
  insertion and deletion by ensuring each real node has two neighbors.
