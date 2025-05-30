
public class ExerciseStrings {
    public static void main(String[] args) {

//      Part 1. Basic String Operations
//       p1.1 Declare and assign the following string variables.
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName.concat(" ").concat(lastName);

//       p1.2 Print 'fullName'.
        System.out.println("Full name: "+ fullName);

//       p1.3 Find the length of 'fullName' and print it.
        System.out.println("Length: " + fullName.length());

//       p1.4 Extract and print the first character using 'charAt(0)'.
        System.out.println("First character: " + fullName.charAt(0));

//       p1.5 Find the position of the letter 'r' in 'fullName' using 'indexOf()'.
        System.out.println("Index of 'r': " + fullName.indexOf('r'));
    }
}