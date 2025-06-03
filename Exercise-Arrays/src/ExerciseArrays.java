import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ExerciseArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
    }
}