# Week 7 Recursion - Java Demonstration Library

Each numbered folder contains an independent Java program with explanatory comments.
Compile and run a program from inside its folder:

```powershell
cd 02_FactorialTrace
javac FactorialTraceDemo.java
java FactorialTraceDemo
```

## Teaching order

| Folder | Main concept |
|---|---|
| `01_RecursionBasics` | Smaller problem, base case, and recursive case |
| `02_FactorialTrace` | Calls going down and return values coming up |
| `03_LinearSum` | Linear recursion with one call per level |
| `04_RecursiveArrayReversal` | Shrinking ranges and helper parameters |
| `05_TailRecursion` | Tail recursion compared with iteration |
| `06_RecursiveBinarySearch` | One recursive call on half the input |
| `07_RecursivePowers` | Reduce by one versus divide by two |
| `08_EnglishRulerBinaryRecursion` | Two calls in each non-base case |
| `09_RecursionClassification` | Linear, binary, and multiple recursion |
| `10_BinarySum` | Binary recursion with `O(n)` total work |
| `11_FibonacciComparison` | Repeated subproblems and exponential growth |
| `12_BacktrackingPermutations` | Choose, recurse, undo, and try again |
| `13_SummationPuzzle` | Textbook `PuzzleSolve` pattern applied through backtracking |
| `14_CommonRecursionMistakes` | Missing base cases and failure to make progress |

## Central reminders

- Every possible call chain must reach a base case.
- A recursive call must work on a smaller or simpler problem.
- Java does not guarantee tail-call optimization.
- Binary search is linear recursion because each call chooses only one half.
- Binary recursion does not automatically mean exponential time. Repeated work,
  as seen in naive Fibonacci, is what causes the exponential growth there.
- Recursion uses call-stack space in addition to its ordinary data storage.
