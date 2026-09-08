# Week 2 Java Demonstration Library

These examples introduce one idea at a time. Each folder is independent, uses only standard Java, and contains a class with a `main()` method. Run the commands from the `Week2` directory using Windows Command Prompt or PowerShell.

## Teaching sequence

| Folder | Concept | File to open | What students should notice |
|---|---|---|---|
| `01_ClassAndObject` | Classes and objects | `ClassAndObjectDemo.java` | Two objects made from one class keep separate state. |
| `02_Encapsulation` | Encapsulation | `EncapsulationDemo.java` | Private data is read and changed through controlled methods. |
| `03_Abstraction_ADT` | Abstraction and ADTs | `SimpleStackDemo.java` | A caller uses stack operations without knowing the array implementation. |
| `04_Interface` | Interfaces | `InterfaceDemo.java` | Different classes satisfy the same `Flyable` contract differently. |
| `05_AbstractClass` | Abstract classes | `AbstractClassDemo.java` | An abstract class supplies shared members while requiring subclass behavior. |
| `06_Inheritance` | Inheritance | `InheritanceDemo.java` | A `Lion` inherits state and behavior from `Animal` and adds its own method. |
| `07_Constructor_This` | Constructors and `this` | `ConstructorDemo.java` | A constructor initializes fields, and `this` distinguishes fields from parameters. |
| `08_Inheritance_Super` | Parent constructors and `super()` | `SuperConstructorDemo.java` | The parent constructor runs before the child constructor. |
| `09_MethodOverriding` | Method overriding | `MethodOverridingDemo.java` | A child replaces an inherited method using the same signature. |
| `10_Polymorphism_DynamicDispatch` | Polymorphism | `PolymorphismDemo.java` | The same method call produces behavior chosen from the actual object at runtime. |
| `11_Progression_Inheritance` | Inheritance progression | `ProgressionDemo.java` | Subclasses reuse one printing method while overriding how values advance. |
| `12_Exception_Basic` | Exception basics | `ExceptionBasicDemo.java` | Invalid conversion can cause an exception during execution. |
| `13_TryCatch` | `try` and `catch` | `TryCatchDemo.java` | Valid input follows the normal path; invalid input follows the catch path. |
| `14_Throw` | `throw` | `ThrowDemo.java` | A method can deliberately signal invalid data with an exception. |
| `15_ThrowVsThrows` | `throw` versus `throws` | `ThrowVsThrowsDemo.java` | `throw` is an action; `throws` is a declaration. |
| `16_WideningCasting` | Widening | `WideningDemo.java` | A child object can automatically be assigned to a parent reference. |
| `17_NarrowingCasting` | Narrowing | `NarrowingDemo.java` | Downcasting is explicit, and `instanceof` can check it first. |
| `18_Generics_Basic` | Collection generics | `GenericsBasicDemo.java` | A type argument limits which values a collection accepts. |
| `19_GenericClass` | Generic classes | `GenericBoxDemo.java` | `T` is replaced by a concrete type for each `Box`. |
| `20_NestedClass` | Nested classes | `NestedClassDemo.java` | A small helper class can live inside the class that uses it. |
| `21_CombinedZooPractice` | Combined OOP practice | `ZooDemo.java` | Inheritance, overriding, polymorphism, constructors, and an interface work together. |

## Compile and run

### 01 - Classes and objects

```powershell
cd 01_ClassAndObject
javac ClassAndObjectDemo.java
java ClassAndObjectDemo
cd ..
```

### 02 - Encapsulation

```powershell
cd 02_Encapsulation
javac EncapsulationDemo.java
java EncapsulationDemo
cd ..
```

### 03 - Abstraction and ADTs

```powershell
cd 03_Abstraction_ADT
javac SimpleStackDemo.java
java SimpleStackDemo
cd ..
```

### 04 - Interface

```powershell
cd 04_Interface
javac InterfaceDemo.java
java InterfaceDemo
cd ..
```

### 05 - Abstract class

```powershell
cd 05_AbstractClass
javac AbstractClassDemo.java
java AbstractClassDemo
cd ..
```

### 06 - Inheritance

```powershell
cd 06_Inheritance
javac InheritanceDemo.java
java InheritanceDemo
cd ..
```

### 07 - Constructor and `this`

```powershell
cd 07_Constructor_This
javac ConstructorDemo.java
java ConstructorDemo
cd ..
```

### 08 - Inheritance and `super()`

```powershell
cd 08_Inheritance_Super
javac SuperConstructorDemo.java
java SuperConstructorDemo
cd ..
```

### 09 - Method overriding

```powershell
cd 09_MethodOverriding
javac MethodOverridingDemo.java
java MethodOverridingDemo
cd ..
```

### 10 - Polymorphism and dynamic dispatch

```powershell
cd 10_Polymorphism_DynamicDispatch
javac PolymorphismDemo.java
java PolymorphismDemo
cd ..
```

### 11 - Progression inheritance

```powershell
cd 11_Progression_Inheritance
javac ProgressionDemo.java
java ProgressionDemo
cd ..
```

### 12 - Exception basics

```powershell
cd 12_Exception_Basic
javac ExceptionBasicDemo.java
java ExceptionBasicDemo
cd ..
```

### 13 - Try and catch

```powershell
cd 13_TryCatch
javac TryCatchDemo.java
java TryCatchDemo
cd ..
```

### 14 - Throw

```powershell
cd 14_Throw
javac ThrowDemo.java
java ThrowDemo
cd ..
```

### 15 - Throw versus throws

```powershell
cd 15_ThrowVsThrows
javac ThrowVsThrowsDemo.java
java ThrowVsThrowsDemo
cd ..
```

### 16 - Widening

```powershell
cd 16_WideningCasting
javac WideningDemo.java
java WideningDemo
cd ..
```

### 17 - Narrowing

```powershell
cd 17_NarrowingCasting
javac NarrowingDemo.java
java NarrowingDemo
cd ..
```

### 18 - Basic generics

```powershell
cd 18_Generics_Basic
javac GenericsBasicDemo.java
java GenericsBasicDemo
cd ..
```

### 19 - Generic class

```powershell
cd 19_GenericClass
javac GenericBoxDemo.java
java GenericBoxDemo
cd ..
```

### 20 - Nested class

```powershell
cd 20_NestedClass
javac NestedClassDemo.java
java NestedClassDemo
cd ..
```

### 21 - Combined Zoo practice

```powershell
cd 21_CombinedZooPractice
javac ZooDemo.java
java ZooDemo
cd ..
```

The generated `.class` files may be deleted after class. Recompile whenever a `.java` file changes.
