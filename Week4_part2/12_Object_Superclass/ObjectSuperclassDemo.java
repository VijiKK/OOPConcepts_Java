/*
 * CONCEPT: Object is the superclass at the top of every Java class hierarchy.
 *
 * Even though Question does not explicitly write "extends Object", it
 * inherits Object methods such as toString(), equals(), and hashCode().
 */

class Question {
    // No methods are needed to inherit Object's public methods.
}

public class ObjectSuperclassDemo {

    public static void main(String[] args) {
        Question question = new Question();

        // Upcasting to Object is valid for every Java object.
        Object objectReference = question;

        System.out.println("Question is an Object: "
                + (objectReference instanceof Object));
        System.out.println("Runtime class: "
                + objectReference.getClass().getSimpleName());

        // Object.toString() normally has ClassName@hexHashCode form.
        String defaultText = objectReference.toString();
        String expectedEnding = Integer.toHexString(objectReference.hashCode());
        System.out.println("Default toString starts with Question@: "
                + defaultText.startsWith("Question@"));
        System.out.println("toString includes hashCode in hexadecimal: "
                + defaultText.endsWith(expectedEnding));

        // Object.equals() behaves like identity unless a class overrides it.
        System.out.println("An object equals itself: "
                + objectReference.equals(question));
    }
}

/*
Expected output:
Question is an Object: true
Runtime class: Question
Default toString starts with Question@: true
toString includes hashCode in hexadecimal: true
An object equals itself: true
*/
