# Week 8 Searching Algorithms - Java Demonstration Library

Each numbered folder contains an independent runnable Java example with a concept
summary and detailed inline comments. Compile and run from inside one folder:

```powershell
cd 04_IterativeBinarySearch
javac IterativeBinarySearchDemo.java
java IterativeBinarySearchDemo
```

## Teaching order

| Folder | Main concept |
|---|---|
| `01_SearchingBasics` | Target, index, successful result, and `-1` |
| `02_LinearSearchTrace` | Sequential comparison trace |
| `03_LinearSearchComplexity` | Best, average, and worst cases |
| `04_IterativeBinarySearch` | `low`, `high`, `middle`, and halving |
| `05_RecursiveBinarySearch` | Base case, smaller range, and stack space |
| `06_BinarySearchPrecondition` | Why binary search requires sorted input |
| `07_SearchComparison` | `O(n)` versus `O(log n)` comparison counts |
| `08_SearchTimingExperiment` | Warm-up, repeated timing, and measurement noise |
| `09_FirstOccurrence` | First duplicate position in `O(log n)` |
| `10_LastOccurrence` | Last duplicate position in `O(log n)` |
| `11_CountOccurrences` | Count duplicates using first and last positions |
| `12_RotatedArraySearch` | Binary search in rotated sorted data |
| `13_BinarySearchPitfalls` | Midpoint overflow and boundary errors |
| `14_IntegerSquareRoot` | Binary search over a numeric answer range |
| `15_SortedMatrixSearch` | Top-right matrix search in `O(m+n)` |
| `16_PeakFinding` | Binary-search-style peak location |
| `17_PracticeLinearSearch` | Completed practice problem 1 |
| `18_PracticeBinarySearch` | Completed iterative/recursive practice problem 2 |
| `19_PracticeSearchAnalysis` | Completed comparison-table practice problem 3 |

## Central comparison

| Property | Linear search | Binary search |
|---|---|---|
| Required ordering | None | Sorted |
| Worst-case time | `O(n)` | `O(log n)` |
| Iterative auxiliary space | `O(1)` | `O(1)` |
| Recursive auxiliary space | Not used here | `O(log n)` |

Use comparison counts to explain asymptotic behavior. Use elapsed time only as an
experiment because JVM warm-up, hardware, and other system activity affect it.
