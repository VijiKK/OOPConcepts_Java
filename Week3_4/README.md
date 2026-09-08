# Week 3 and 4 Java Demonstration Library

These examples follow the supplied Week 3 and 4 slides and practice assignment. Each folder introduces one main idea, contains detailed teaching comments, and can be compiled independently with standard Java.

Run the commands below from the `Week3_4` directory. Examples 20 and 22 use real Java packages, so their compile commands include all related source files.

## Teaching sequence

| Folder | Concept | Main file | What students should notice |
|---|---|---|---|
| `01_DiscoveringClasses` | Discovering classes | `DiscoveringClassesDemo.java` | Problem-domain nouns often suggest useful classes. |
| `02_Cohesion` | Cohesion | `CohesionDemo.java` | `Coin` and `CashRegister` each have one focused responsibility. |
| `03_OneWayDependency` | Dependencies | `DependencyDemo.java` | `ShoppingCart` uses `Product`, but `Product` does not use `ShoppingCart`. |
| `04_DecouplingInputOutput` | Separating logic and output | `DecouplingDemo.java` | A domain class returns data while the application decides how to display it. |
| `05_AccessorsAndMutators` | Accessors and mutators | `AccessorMutatorDemo.java` | An accessor observes state; a mutator changes state. |
| `06_ImmutableClass` | Immutability | `ImmutableClassDemo.java` | No setter can change a `CourseCode` after construction. |
| `07_MinimizingSideEffects` | Side effects | `SideEffectsDemo.java` | A calculation reads its input list without destroying or changing it. |
| `08_KeepingATotal` | Running-total pattern | `KeepingTotalDemo.java` | One field preserves a total across method calls. |
| `09_CountingEvents` | Counter pattern | `CountingEventsDemo.java` | Each event increments stored state. |
| `10_CollectingValues` | Object collections | `CollectingValuesDemo.java` | An object can construct and manage an `ArrayList`. |
| `11_ValidatedProperty` | Validated properties | `ValidatedPropertyDemo.java` | A setter protects a property from invalid values. |
| `12_ReadOnlyProperty` | Fixed properties | `ReadOnlyPropertyDemo.java` | Some properties need a getter but deliberately have no setter. |
| `13_ModelingDistinctStates` | State-dependent behavior | `StateDemo.java` | Methods change state, and current state changes later behavior. |
| `14_PositionOnLine` | Position on a line | `PositionOnLineDemo.java` | Movement updates a stored distance. |
| `15_PositionOnGrid` | Position and direction | `GridPositionDemo.java` | Direction determines which coordinate changes. |
| `16_StaticVariable` | Static variables | `StaticVariableDemo.java` | Objects have separate fields but share one class-level counter. |
| `17_StaticConstant` | Static constants | `StaticConstantDemo.java` | A class constant is accessed through the class name. |
| `18_StaticMethod` | Static methods | `StaticMethodDemo.java` | A utility calculation requires no object state. |
| `19_SolveSimplerProblemFirst` | Incremental problem solving | `PhotoLayoutDemo.java` | A layout algorithm grows from placing one item to handling rows. |
| `20_PackagesAndImports` | Packages and imports | `PackageDemo.java` | Package declarations match folders, and imports shorten class names. |
| `21_UnitTestingConcept` | Unit-test structure | `ManualUnitTestDemo.java` | Tests compare expected and actual results automatically. |
| `22_BankAccountPractice` | Combined practice | `BankAccountPractice.java` | Packages, static members, validation, utility methods, and objects work together. |

## Compile and run

### 01 Discovering classes

```powershell
cd 01_DiscoveringClasses
javac DiscoveringClassesDemo.java
java DiscoveringClassesDemo
cd ..
```

### 02 Cohesion

```powershell
cd 02_Cohesion
javac CohesionDemo.java
java CohesionDemo
cd ..
```

### 03 One-way dependency

```powershell
cd 03_OneWayDependency
javac DependencyDemo.java
java DependencyDemo
cd ..
```

### 04 Decoupling input and output

```powershell
cd 04_DecouplingInputOutput
javac DecouplingDemo.java
java DecouplingDemo
cd ..
```

### 05 Accessors and mutators

```powershell
cd 05_AccessorsAndMutators
javac AccessorMutatorDemo.java
java AccessorMutatorDemo
cd ..
```

### 06 Immutable class

```powershell
cd 06_ImmutableClass
javac ImmutableClassDemo.java
java ImmutableClassDemo
cd ..
```

### 07 Minimizing side effects

```powershell
cd 07_MinimizingSideEffects
javac SideEffectsDemo.java
java SideEffectsDemo
cd ..
```

### 08 Keeping a total

```powershell
cd 08_KeepingATotal
javac KeepingTotalDemo.java
java KeepingTotalDemo
cd ..
```

### 09 Counting events

```powershell
cd 09_CountingEvents
javac CountingEventsDemo.java
java CountingEventsDemo
cd ..
```

### 10 Collecting values

```powershell
cd 10_CollectingValues
javac CollectingValuesDemo.java
java CollectingValuesDemo
cd ..
```

### 11 Validated property

```powershell
cd 11_ValidatedProperty
javac ValidatedPropertyDemo.java
java ValidatedPropertyDemo
cd ..
```

### 12 Read-only property

```powershell
cd 12_ReadOnlyProperty
javac ReadOnlyPropertyDemo.java
java ReadOnlyPropertyDemo
cd ..
```

### 13 Modeling distinct states

```powershell
cd 13_ModelingDistinctStates
javac StateDemo.java
java StateDemo
cd ..
```

### 14 Position on a line

```powershell
cd 14_PositionOnLine
javac PositionOnLineDemo.java
java PositionOnLineDemo
cd ..
```

### 15 Position on a grid

```powershell
cd 15_PositionOnGrid
javac GridPositionDemo.java
java GridPositionDemo
cd ..
```

### 16 Static variable

```powershell
cd 16_StaticVariable
javac StaticVariableDemo.java
java StaticVariableDemo
cd ..
```

### 17 Static constant

```powershell
cd 17_StaticConstant
javac StaticConstantDemo.java
java StaticConstantDemo
cd ..
```

### 18 Static method

```powershell
cd 18_StaticMethod
javac StaticMethodDemo.java
java StaticMethodDemo
cd ..
```

### 19 Solve a simpler problem first

```powershell
cd 19_SolveSimplerProblemFirst
javac PhotoLayoutDemo.java
java PhotoLayoutDemo
cd ..
```

### 20 Packages and imports

```powershell
cd 20_PackagesAndImports
javac -d . school\Student.java PackageDemo.java
java PackageDemo
cd ..
```

### 21 Unit-testing concept

```powershell
cd 21_UnitTestingConcept
javac ManualUnitTestDemo.java
java ManualUnitTestDemo
cd ..
```

This example demonstrates the expected-versus-actual testing pattern without external libraries. JUnit uses annotations and test runners to automate the same core idea.

### 22 Combined Bank Account practice

```powershell
cd 22_BankAccountPractice
javac -d . bank\BankAccount.java bank\utils\BankUtils.java BankAccountPractice.java
java BankAccountPractice
cd ..
```

Delete generated `.class` files after class if desired. Recompile whenever a `.java` source file changes.
