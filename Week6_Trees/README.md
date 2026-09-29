# Week 6: Trees

These independent Java programs follow the original 19-slide tree deck, the
grouped concept slides, and the classroom narration. Each source contains
summary comments, explanations beside meaningful lines, and expected output.

## Learning sequence

| Folder | Main concept | Source slides |
| --- | --- | --- |
| `01_Tree_Hierarchy` | Hierarchical data and general-tree nodes | 1-2 |
| `02_Tree_Terminology` | Root, leaf, ancestor, depth, height, subtree | 3 |
| `03_Tree_ADT_Positions` | Position abstraction and Tree ADT operations | 4-5 |
| `04_Binary_Tree_ADT` | Ordered left/right children and sibling | 8, 12 |
| `05_Recursion_Basics` | Self-calls, smaller problems, base case | Grouped recursion slide |
| `06_Preorder_Traversal` | Root, Left, Right | 6 |
| `07_Inorder_Traversal` | Left, Root, Right | 13 |
| `08_Postorder_Traversal` | Left, Right, Root | 7 |
| `09_Recursion_Backtracking` | Call, return to parent, then continue | Grouped traversal slide |
| `10_Expression_Tree` | Infix printing and postorder evaluation | 9, 14-15 |
| `11_Decision_Tree` | Questions, outcome branches, action leaves | 10 |
| `12_Proper_Binary_Properties` | Proper-tree counts and height properties | 11 |
| `13_Euler_Tour` | Preorder/inorder/postorder events in one walk | 16 |
| `14_Linked_Representation` | Parent, left, and right references | 17-18 |
| `15_Array_Representation` | Parent/child index formulas | 19 |
| `16_File_System_Practice` | General tree and postorder aggregation | 2, 7 |

## Compile and run

Run each example from its own folder:

```powershell
cd .\01_Tree_Hierarchy
javac .\TreeHierarchyDemo.java
java TreeHierarchyDemo
```

Use the class name with `java`, without `.java` or `.class`.

## Traversal memory aid

- Preorder: Root, Left, Right.
- Inorder: Left, Root, Right.
- Postorder: Left, Right, Root.

"Visit" means process a node. Processing may print, count, evaluate, update,
or otherwise use its element.

## Representation comparison

- Linked representation stores references to node objects. It handles sparse
  and changing trees naturally.
- Array representation calculates relationships from indices. It is compact
  for complete or nearly complete binary trees but may waste cells for sparse
  trees.
- The links and array cells hold references to nodes/elements, not full copies
  of the referenced objects.
