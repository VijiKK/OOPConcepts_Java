# Week 4 Part 2: Inheritance and Polymorphism

These small Java programs follow the inheritance sequence in the original
Week 4 slides. Each folder introduces one main idea so it can be compiled,
run, and explained independently during class.

## Learning sequence

| Folder | Main idea | Original slides |
| --- | --- | --- |
| `01_Inheritance_IsA` | Superclass, subclass, `extends`, and is-a | 1-3 |
| `02_Reuse_Substitution` | Reuse and the substitution principle | 4-5 |
| `03_Question_Superclass` | The general `Question` class | 6-7 |
| `04_Creating_ChoiceQuestion` | Inherited and added members | 8-13 |
| `05_Private_Superclass_Data` | Private parent data and public methods | 14-16 |
| `06_Overriding_SuperMethod` | Overriding and `super.method()` | 17-18 |
| `07_Complete_ChoiceQuestion` | Complete question hierarchy | 19-21 |
| `08_Super_Constructor` | Constructor chaining with `super(...)` | 22, 25 |
| `09_Common_Inheritance_Mistakes` | Override/overload, recursion, `final` | 23-24 |
| `10_Polymorphism_Substitution` | A `Question` parameter accepts subclasses | 26-28 |
| `11_Dynamic_Method_Lookup` | Runtime choice of overridden methods | 29-31 |
| `12_Object_Superclass` | `Object`, `toString`, `equals`, `hashCode` | 32-33 |
| `13_ToString_Override` | Default and customized object text | 34-35 |
| `14_Equals_Vs_Identity` | `equals()` versus `==` | 36-39 |
| `15_Casting_Instanceof` | Upcasting, downcasting, and `instanceof` | 40 |

## Compile and run

Run each example from its own folder. For example:

```powershell
cd .\01_Inheritance_IsA
javac .\InheritanceIsADemo.java
java InheritanceIsADemo
```

Java receives a class name, not a file name. Therefore, use
`java InheritanceIsADemo`, not `java InheritanceIsADemo.class`.

Each source file ends with its expected output. The commented `WRONG` lines
are intentional teaching examples and remain commented so the files compile.

## Suggested classroom flow

1. Begin with folders 01-03 to establish the parent/child vocabulary.
2. Develop `ChoiceQuestion` gradually with folders 04-07.
3. Use folders 08-09 for important syntax and frequent mistakes.
4. Spend the most discussion time on folders 10-11: substitution and dynamic
   method lookup are the central connection between inheritance and
   polymorphism.
5. End with folders 12-15 as an introduction to methods inherited from
   `Object`, value equality, and safe casting.

The examples use the default package on purpose. This lets each classroom
demo compile directly inside its folder without requiring a source-root setup.
