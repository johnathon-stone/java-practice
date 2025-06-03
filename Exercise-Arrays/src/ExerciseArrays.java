import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExerciseArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
//** Part 1: Basic Array Operations
//*     1. Declare & Assign an Array.
//       1.1 Create an array of 5 city names and assign values directly.
        String[] cityNames = new String[5];
        cityNames[0] = "Austin";
        cityNames[1] = "Atlanta";
        cityNames[2] = "San Diego";
        cityNames[3] = "Philadelphia";
        cityNames[4] = "New York";
//       1.2 Print each city using its index.
        System.out.println(cityNames[0]);
        System.out.println(cityNames[1]);
        System.out.println(cityNames[2]);
        System.out.println(cityNames[3]);
        System.out.println(cityNames[4]);

//*     2. Access & Modify Elements.
//       2.1 Update the 3rd city in the array to a different name.
        cityNames[2] = "Boston";
//       2.2 Print the updated array.
        System.out.println(cityNames[2]);

//*     3. Find the length of an Array.
//       3.1 Print the total number of cities in your array using .length.
        System.out.println(cityNames.length);

//** Part 2: Iterating Over Arrays.
//*     4. Print Array Elements Using a loop.
//       4.1 Loop through the city names array using a for loop and print each city.
        for (int i = 0; i < cityNames.length; i++) {
            System.out.println(cityNames[i]);
        }

//*     5. Reverse the Array.
//       5.1 Use a for loop to print the city names in reverse order.
        for (int x = 4; x >= 0; x--) {
            System.out.println(cityNames[x]);
        }

//*     6. Find a Specific Element.
//       6.1 Ask the user to enter a city name.
        System.out.println("Enter a city name: ");
        String cityAnswer = input.nextLine();
//       6.2 Check if the city is in your array.
        boolean found = false;
        for (String city : cityNames) {
            if (city.equalsIgnoreCase(cityAnswer)) {
                found = true;
                break;
            }
        }
//       6.3 Print "City found!" if it exitsts, otherwise "City not found!".
        if (found) {
            System.out.println("City found!");
        } else {
            System.out.println("City not found!");
        }

//** Part 3: Numeric Arrays & Calculations.
//*     7. Sum of Numbers in an Array.
//       7.1 Create an array of 5 test scores.
        double[] testScores = {77.8, 93.1, 55.7, 100, 89.5};
//       7.2 Loop through the array and calculate the sum of all scores.
        double sum = 0.0;
        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
//       7.3 Print the total.
        System.out.println("The sum of all the test scores is: " + sum);

//*     8. Find the Maximum & Minimum.
//       8.1 Use a loop to find the highest and lowest test score in the array.
        double highestGrade = 0.0;
        double lowestGrade = 100.0;
        for (int i = 0; i < testScores.length; i++) {
            if (highestGrade < testScores[i]) {
                highestGrade = testScores[i];
                if (lowestGrade > testScores[i]) {
                    lowestGrade = testScores[i];
                }
            }
        }
//       8.2 Print both values.
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);

//*     9. Calculate the Average.
//       9.1 Compute and print the average score.
        double avgScore = sum / testScores.length;
        System.out.println("Average grade: " + avgScore);

//** Part 4. Advanced Challenges.
//*     10. Count Occurrences of a Value.
//       10.1 Create an array of 10 random numbers between 1 and 5.
        int[] randNum = new int[10];
        for (int i = 0; i < randNum.length; i++) {
            randNum[i] = random.nextInt(1, 5);
        }
//       10.2 Count how many times the number 3 appears in the array.
        int threeCount = 0;
        for (int i = 0; i < randNum.length; i++) {
            if (randNum[i] == 3) {
                threeCount++;
            }
        }
        System.out.println("The number three appeared: " + threeCount);

//*     11. Shift Elements in an Array.
//       11.1 Given an array {1, 2, 3, 4, 5}, modify it so that:
//        *The first element moves to the last position.
//        *The remaining elements shift one step left.
//        *Output: {2, 3, 4, 5, 1}.
        int[] shiftElements = {1, 2, 3, 4, 5};
        int firstElement = shiftElements[0];
        for (int i = 0; i < shiftElements.length - 1; i++) {
            shiftElements[i] = shiftElements[i + 1];
        }
        shiftElements[shiftElements.length - 1] = firstElement;
        System.out.println(Arrays.toString(shiftElements));

//*     12. Check for Duplicates.
//       12.1 Create an array of 6 student names.
        String[] studentNames = {"Richard","Michael", "Eric", "Jon", "James", "Paul"};
//       12.2 Check if the array contains duplicate names.
        Arrays.sort(studentNames);
        boolean duplicateNames = false;
        for (int i = 0; i < studentNames.length - 1; i++) {
            if (studentNames[i] == studentNames[i + 1]) {
                duplicateNames = true;
                break;
            }
        }
//       12.3 Print "Duplicates found!" if any name appears more than once.
        if (duplicateNames) {
            System.out.println("Duplicates found!");
        } else {
            System.out.println("No duplicates found.");
        }

//** Bonus Challenge: Mini Address Book.
//*     13. Store and Print Contact Information.
//       13.1 Create three parallel arrays:
//        *A String[] for names.
//        *A String[] for phone numbers.
//        *A String[] for email addresses.
//       13.2 Populate them with at least 3 contacts.
//       13.3 Ask the user for a name.
//       13.4 If found, print the contact's phone number and email.

//** Final Challenge: Array Sorting (Optional).
//*     14. Sort an Array Alphabetically.
//       14.1 Create an array of 5 fruit names.
//       14.2 Sort them in alphabetical order.
//       14.3 Print the sorted array.

//*     15. Sort an Array of Numbers.
//       15.1 Create an array of 10 random numbers.
//       15.2 Sort them in ascending order.
//       15.3 Print the sorted list.
    }
}