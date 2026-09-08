I am teaching CPSC 5002 – Fundamentals of Programming and Algorithms using Java.

I need a set of very simple, classroom-friendly Java programs for Week 2 on Object-Oriented Programming.

Please create all files under this folder:

C:\Viji\From2026_workrelated\UTC_Faculty_Jun2026\Fall_2026\CPSC 5002\JavaCode\Week2

IMPORTANT TEACHING GOAL:
These programs are not meant to be sophisticated software projects.
They are small demonstrations that I can open in class, explain line-by-line, run, and show the students the actual output.

Students are still learning Java, so:
- keep code simple
- avoid advanced syntax unless the concept requires it
- use meaningful variable and class names
- include comments, but do not over-comment every line
- avoid unnecessary packages/frameworks
- use System.out.println for visible output
- every runnable example should have a main() method
- include expected output as a short comment at the bottom of the main demo file
- make sure every example compiles and runs independently
- verify all code before finishing

ORGANIZATION:

Create a separate folder for each major concept.

If one concept needs several classes, either:
1. keep them in one Java file using one public class and package-private helper classes, if that is valid and easier for teaching, OR
2. place the related Java files in the same concept folder.

Prefer the simplest organization for classroom teaching.

Use numbered folders so they appear in teaching order.

Please create examples for the following concepts.

==================================================
01_ClassAndObject
==================================================

Demonstrate:
- class as a blueprint
- object as an instance
- fields/state
- methods/behavior
- creation of two objects from the same class
- each object having different field values

Use a simple Student example.

Suggested files:
01_ClassAndObject/
    ClassAndObjectDemo.java

Show output that makes it obvious that two objects have separate state.

==================================================
02_Encapsulation
==================================================

Demonstrate:
- private fields
- controlled access through methods
- getter
- a method that validates data before modifying a field

Use a BankAccount example.

For example:
- private double balance
- getBalance()
- deposit(double amount)
- reject negative deposits

Do not introduce exceptions yet in this example.
Just print a simple validation message.

Suggested:
02_Encapsulation/
    EncapsulationDemo.java

==================================================
03_Abstraction_ADT
==================================================

Demonstrate the idea:
WHAT operations are available versus HOW they are implemented.

Use a very simple Stack-like example if possible.

Operations:
- push
- pop
- top

The goal is NOT to teach full stack implementation yet.
Keep the implementation extremely small, perhaps using an array.

Explain through comments that a user calls push/pop/top without needing to understand the internal array implementation.

Suggested:
03_Abstraction_ADT/
    SimpleStackDemo.java

==================================================
04_Interface
==================================================

Demonstrate:
- interface as a contract
- method declaration in interface
- class implements interface
- different classes can implement the same interface differently

Use:

interface Flyable
    void fly()

Classes:
Parrot
Airplane

Then run both.

Suggested:
04_Interface/
    InterfaceDemo.java

==================================================
05_AbstractClass
==================================================

Demonstrate:
- abstract class cannot be instantiated
- common field in abstract class
- normal method in abstract class
- abstract method
- subclasses must implement abstract behavior

Use:
abstract class Animal

Possible members:
String name
displayName()
abstract makeSound()

Subclasses:
Lion
Elephant

Suggested:
05_AbstractClass/
    AbstractClassDemo.java

==================================================
06_Inheritance
==================================================

Demonstrate:
- superclass
- subclass
- extends
- inherited fields or methods
- "is-a" relationship
- adding new behavior in the subclass

Use:
Animal
Lion

Keep this example focused on inheritance.
Do not make polymorphism the primary concept yet.

Suggested:
06_Inheritance/
    InheritanceDemo.java

==================================================
07_Constructor_This
==================================================

Demonstrate:
- constructor
- constructor name matches class
- constructor initializes object state
- this.field = parameter

Use a Student or Animal example.

Suggested:
07_Constructor_This/
    ConstructorDemo.java

==================================================
08_Inheritance_Super
==================================================

Demonstrate:
- parent constructor
- child constructor
- constructors are not inherited
- super(...)
- superclass initialization happens first

Use:
Animal
Lion

Print messages from both constructors so students can SEE the order.

For example:

Animal constructor running
Lion constructor running

Suggested:
08_Inheritance_Super/
    SuperConstructorDemo.java

==================================================
09_MethodOverriding
==================================================

Demonstrate:
- same method signature
- subclass provides a new implementation
- @Override

Use:
Animal.makeSound()
Lion.makeSound()
Elephant.makeSound()

Suggested:
09_MethodOverriding/
    MethodOverridingDemo.java

Also add a short comment explaining:

Overloading:
same method name, different parameters

Overriding:
same method signature in parent and child, new child implementation

Do NOT make overloading a major example here.

==================================================
10_Polymorphism_DynamicDispatch
==================================================

This is very important.

Use:
Animal
Lion
Elephant
Parrot

Create:

Animal a = new Lion(...);

Call:
a.makeSound();

Then demonstrate:

Animal[] animals = {
    new Lion(...),
    new Elephant(...),
    new Parrot(...)
};

Loop:

for (Animal animal : animals) {
    animal.makeSound();
}

Output should clearly show:
Roar!
Trumpet!
Squawk!

Add comments explaining:

Reference type = Animal
Actual object type = Lion / Elephant / Parrot

Java chooses the overridden method based on the actual object at runtime.

Use the phrase:
"Same method call, different object, different behavior."

Suggested:
10_Polymorphism_DynamicDispatch/
    PolymorphismDemo.java

==================================================
11_Progression_Inheritance
==================================================

Create a simplified version of the textbook progression example.

Use:
Progression
ArithmeticProgression
GeometricProgression
FibonacciProgression

The purpose is to demonstrate:
- common superclass
- subclasses
- overriding
- reuse of common code
- dynamic dispatch

Do not make the mathematics complicated.

Show short outputs such as:

Arithmetic:
2 5 8 11 14

Geometric:
2 6 18 54 162

Fibonacci:
0 1 1 2 3 5 8

If it is clearer, place the classes in separate files in the same folder.

Suggested:
11_Progression_Inheritance/
    Progression.java
    ArithmeticProgression.java
    GeometricProgression.java
    FibonacciProgression.java
    ProgressionDemo.java

==================================================
12_Exception_Basic
==================================================

Demonstrate what an exception is.

Use:

Integer.parseInt("hello")

First, perhaps comment out the failing line or explain what happens if run without handling.

Then show a safe demonstration.

Explain:
exception happens during execution.

Suggested:
12_Exception_Basic/
    ExceptionBasicDemo.java

==================================================
13_TryCatch
==================================================

Demonstrate:
- try
- catch
- normal execution
- exception execution

Use:

Integer.parseInt(input)

Run two examples:
1. input = "25"
2. input = "hello"

Show the difference clearly.

Suggested:
13_TryCatch/
    TryCatchDemo.java

==================================================
14_Throw
==================================================

Demonstrate manually throwing an exception.

Use BankAccount:

deposit(double amount)

If amount < 0:

throw new IllegalArgumentException(
    "Deposit cannot be negative"
);

Catch it in main so the program continues and students can see the output.

Suggested:
14_Throw/
    ThrowDemo.java

==================================================
15_ThrowVsThrows
==================================================

Create one small example that clearly demonstrates the difference:

throw
= actually creates/sends an exception

throws
= declares that a method may throw an exception

Prefer using a simple checked exception such as IOException so the purpose of throws is meaningful.

Keep file handling minimal and easy to understand.

Suggested:
15_ThrowVsThrows/
    ThrowVsThrowsDemo.java

Add a clear comment:

throw  -> action
throws -> declaration

==================================================
16_WideningCasting
==================================================

Use:
Animal
Lion

Demonstrate:

Lion lion = new Lion("Leo");
Animal animal = lion;

Explain:
Lion -> Animal
child -> parent
specific -> general
widening
automatic
no explicit cast required

Then call a common method.

Suggested:
16_WideningCasting/
    WideningDemo.java

==================================================
17_NarrowingCasting
==================================================

Demonstrate:

Animal animal = new Lion("Leo");
Lion lion = (Lion) animal;

Explain:
Animal -> Lion
parent reference -> child reference
explicit cast required

Then include a safe demonstration of an invalid cast.

For example:
Animal animal2 = new Elephant("Ella");

Do NOT terminate the whole classroom demo unexpectedly.
Wrap the invalid cast in try-catch and show:

ClassCastException prevented/handled

Also demonstrate instanceof before casting, because this is useful safe practice:

if (animal instanceof Lion) {
    Lion l = (Lion) animal;
}

Suggested:
17_NarrowingCasting/
    NarrowingDemo.java

==================================================
18_Generics_Basic
==================================================

Start with Java collection generics because students may recognize them.

Demonstrate:

ArrayList<String>
ArrayList<Integer>

Explain:
<String> and <Integer> specify allowed element type.

Show that:
names.add("Alice");

works.

Include this incorrect line as a COMMENT ONLY:

// names.add(25);   // compile-time error

Do not leave code that prevents compilation.

Suggested:
18_Generics_Basic/
    GenericsBasicDemo.java

==================================================
19_GenericClass
==================================================

Create:

class Box<T>

with:
private T item
setItem(T item)
T getItem()

Use:

Box<String>
Box<Integer>

Explain:
T is a placeholder type.

Suggested:
19_GenericClass/
    GenericBoxDemo.java

==================================================
20_NestedClass
==================================================

Demonstrate a class inside another class.

Use:

LinkedListExample
    Node

or another very small data-structure-related example.

Do NOT implement a complete linked list.

Just demonstrate:
- outer class
- nested Node class
- Node stores data and next
- outer class creates/uses nodes

Suggested:
20_NestedClass/
    NestedClassDemo.java

==================================================
21_CombinedZooPractice
==================================================

Create one final example that combines the major OOP ideas from the week.

Use the Zoo Animal Management example.

Requirements:

Base class:
Animal

Fields:
String name
String species

Constructor:
Animal(String name, String species)

Methods:
displayInfo()
makeSound()

Subclasses:
Lion
Elephant
Parrot

Each subclass overrides makeSound().

Parrot may additionally override displayInfo().

Main:
Animal[] animals = {
    new Lion(...),
    new Elephant(...),
    new Parrot(...)
};

Loop through the array and call:

displayInfo()
makeSound()

Also include:

interface Flyable {
    void fly();
}

Have Parrot implement Flyable.

For an advanced/bonus version, also show an abstract Animal version.

Do not make the basic demo unnecessarily complicated.

Suggested folder:

21_CombinedZooPractice/

Possible files:
Animal.java
Lion.java
Elephant.java
Parrot.java
Flyable.java
ZooDemo.java

OR use one file if that is cleaner for classroom teaching.

==================================================
README
==================================================

Create:

Week2/README.md

The README should list all folders in teaching order.

For each example include:

1. Concept name
2. Files to open
3. One-sentence explanation
4. Expected learning point
5. How to compile/run it from Windows command line

For example:

cd 10_Polymorphism_DynamicDispatch
javac PolymorphismDemo.java
java PolymorphismDemo

Adjust commands if multiple Java files are used.

==================================================
FINAL VERIFICATION
==================================================

After creating the files:

1. Compile every runnable example.
2. Run every example.
3. Fix all compilation/runtime errors.
4. Make sure no example depends on another folder.
5. Make sure each folder can be demonstrated independently.
6. Keep output short enough for classroom display.
7. Do not use Maven, Gradle, Spring, or external libraries.
8. Use standard Java only.
9. Prefer Java syntax suitable for beginners.
10. At the end, provide me a concise summary showing:

Folder
Concept
Main file to run
What students should notice

Do not merely describe the code. Actually create all files and verify that they compile and run.