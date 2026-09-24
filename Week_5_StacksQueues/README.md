# Week 5: Stacks and Queues

These programs follow the 33-slide Week 5 stack and queue deck while keeping
each classroom demonstration small and runnable. Every source file includes
detailed comments and expected output.

## Learning sequence

| Folder | Main concept | Original slides |
| --- | --- | --- |
| `01_ADT_Stack_Queue` | ADT behavior versus implementation | 1-4, 21-22, 29 |
| `02_Stack_Operations` | LIFO, push, pop, top, empty behavior | 3-6 |
| `03_Array_Based_Stack` | Array storage, top index, O(1), fixed capacity | 9-12 |
| `04_Linked_Stack_Generics` | Node-based stack and generic element type | 7, 13 |
| `05_Generic_Stack_Reverse` | Reusing one generic stack algorithm | 13 |
| `06_Stack_Applications` | Undo history and JVM method calls | 7-8 |
| `07_Delimiter_HTML_Matching` | Parentheses, brackets, and nested tags | 14-17 |
| `08_Arithmetic_Expression` | Operator precedence with two stacks | 18-20 |
| `09_Queue_Operations` | FIFO, enqueue, dequeue, first | 22-23, 29 |
| `10_Circular_Array_Queue` | Array queue, front, size, modulo, full case | 25-31 |
| `11_Circular_Wrap_Around` | Rear/front index calculations | 25-28 |
| `12_Java_Util_Queue` | `add/offer`, `remove/poll`, `element/peek` | 32 |
| `13_Round_Robin_Comparison` | Scheduling and stack-versus-queue order | 24, 33 |

## Complexity summary

| Operation | Array stack | Linked stack | Circular array queue |
| --- | --- | --- | --- |
| Insert | `push`: O(1) | `push`: O(1) | `enqueue`: O(1) |
| Remove | `pop`: O(1) | `pop`: O(1) | `dequeue`: O(1) |
| Inspect next | `top`: O(1) | `top`: O(1) | `first`: O(1) |
| Space | O(capacity) | O(n) nodes | O(capacity) |

The fixed array implementations throw `IllegalStateException` when full. In
the textbook ADTs, an empty `top`, `pop`, `first`, or `dequeue` returns `null`.

## Compile and run

Run each program from its own folder. For example:

```powershell
cd .\03_Array_Based_Stack
javac .\ArrayStackDemo.java
java ArrayStackDemo
```

Pass the class name to `java`, without `.java` or `.class`.

## Main ideas for students

- An ADT specifies available behavior and boundary conditions. An array or
  linked structure supplies one possible implementation.
- A stack is LIFO. `push`, `pop`, and `top` all use the same active end.
- A queue is FIFO. `enqueue` uses the rear while `dequeue` uses the front.
- A circular queue moves indices instead of shifting array elements.
- Modulo arithmetic wraps an index from the final cell back to index 0.
- Stack applications naturally reverse or nest work. Queue applications serve
  work in arrival order or rotate work fairly.
