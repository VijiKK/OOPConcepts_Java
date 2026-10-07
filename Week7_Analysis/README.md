# Week 7 Algorithm Analysis - Java Demonstration Library

Each numbered folder contains one independent Java program. Compile and run an
example from inside its folder:

```powershell
cd 14_PrefixAverages
javac PrefixAveragesDemo.java
java PrefixAveragesDemo
```

## Teaching order

| Folder | Main concept |
|---|---|
| `01_AlgorithmInputOutput` | Input, algorithm, output, and input size `n` |
| `02_ExperimentalVsTheoretical` | Timing experiments versus growth analysis |
| `03_PrimitiveOperations` | RAM model and simplified operation counting |
| `04_ArrayMaxAnalysis` | Best/worst details and linear growth |
| `05_ConstantTime` | `O(1)` direct access |
| `06_LogarithmicTime` | `O(log n)` binary search |
| `07_LinearTime` | `O(n)` linear search |
| `08_LinearithmicTime` | `O(n log n)` nested linear/logarithmic work |
| `09_QuadraticTime` | `O(n^2)` pair processing |
| `10_CubicTime` | `O(n^3)` triple processing |
| `11_ExponentialTime` | `O(2^n)` subset generation |
| `12_GrowthRateComparison` | Numeric comparison of common growth rates |
| `13_BigORules` | Dominant terms, constants, and lower-order terms |
| `14_PrefixAverages` | Same problem solved in `O(n^2)` and `O(n)` |
| `15_InsertionSortCases` | Best-case `O(n)` and worst-case `O(n^2)` |
| `16_AsymptoticBounds` | Big-O, Big-Omega, and Big-Theta |
| `17_PracticeComplexityMethods` | Completed complexity practice problem |
| `18_PracticeRecursivePower` | Completed recursive-power practice problem |
| `19_PracticeArrayMaximum` | Iterative and recursive maximum practice |

## Growth order

```text
O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(n^3) < O(2^n)
```

Big-O compares growth as `n` becomes large. It does not predict an exact number
of milliseconds. Hardware, the Java runtime, input composition, and constant
factors still affect measurements, especially for small inputs.
