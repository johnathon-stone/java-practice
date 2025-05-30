
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

//      Part 2. Extracting Parts of a String
//       p2.1 Declare a string.
        String sentence = "Learning Java is fun!";

//       p2.2 Extract and print 'Learning', 'Java', and 'fun!'.
        System.out.printf("\nFirst word: %s\n", sentence.substring(0, 8));
        System.out.println("Second word: " + sentence.substring(9, 13));
        System.out.println("Last word: " + sentence.substring(17));
    }
}