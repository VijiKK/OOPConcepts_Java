# Week 6 Graphs - Java Demonstration Library

Each numbered folder is an independent classroom example. Open one folder, compile
its single Java file, and run the public class with the same name.

```powershell
cd 11_DepthFirstSearch
javac DepthFirstSearchDemo.java
java DepthFirstSearchDemo
```

## Teaching order

| Folder | Main idea |
|---|---|
| `01_GraphBasics` | Graph `G = (V, E)`, vertices, edges, and edge data |
| `02_DirectedAndUndirected` | One-way and two-way connections |
| `03_GraphTerminology` | Endpoints, incidence, adjacency, degree, parallel edges, self-loops |
| `04_PathsAndCycles` | Paths, simple paths, cycles, and simple cycles |
| `05_GraphProperties` | Degree-sum formula and maximum edges in a simple graph |
| `06_GraphADT` | Generic vertex and edge positions plus core Graph ADT operations |
| `07_GraphRepresentations` | Edge list, adjacency list, and adjacency matrix |
| `08_RepresentationPerformance` | Operation-cost and storage tradeoffs |
| `09_SubgraphsAndConnectivity` | Subgraphs, spanning subgraphs, and components |
| `10_SpanningForest` | Trees, forests, spanning trees, and spanning forests |
| `11_DepthFirstSearch` | Recursive DFS and backtracking |
| `12_DFSEdgeClassification` | Discovery edges, back edges, and cycle detection |
| `13_DFSPathFinding` | Finding one path with DFS |
| `14_DFSConnectedComponents` | Repeated DFS across a disconnected graph |
| `15_BreadthFirstSearch` | Queue-based BFS and levels |
| `16_BFSEdgeClassification` | BFS discovery edges and cross edges |
| `17_BFSShortestPath` | Minimum-edge paths in an unweighted graph |
| `18_DFSvsBFS` | Side-by-side algorithm comparison |
| `19_AirportGraphPractice` | Combined weighted graph and BFS practice |

## Complexity reminders

- With an adjacency list, complete DFS and BFS traversals take `O(n + m)` time.
- An adjacency matrix uses `O(n^2)` space and checks a particular edge in `O(1)` time.
- BFS finds a path with the fewest edges in an unweighted graph. It does not find
  the lowest-weight route unless all relevant edge weights are equivalent.
- Traversal order can change when neighbor insertion order changes. The examples use
  ordered Java collections so their output stays consistent during a demonstration.
