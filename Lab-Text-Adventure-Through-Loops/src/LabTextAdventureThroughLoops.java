import java.util.Scanner;

public class LabTextAdventureThroughLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//  Established placeholders for the five boolean values.
        boolean keyHalfOne = false;
        boolean keyHalfTwo = false;
        boolean locationOne = false;
        boolean locationTwo = false;
        boolean locationThree = false;
        System.out.println("Welcome");
//  Established while loop with menu.
        while (true) {
            System.out.println("Make a choice between: ");
            System.out.println("Choice 1");
            System.out.println("Choice 2");
            System.out.println("Choice 3");
            System.out.println("Choice 4");

//  Catching user input and assigning it.
            String choice = input.nextLine();

//  Established switch to direct user based on input appropriately.
            switch (choice) {

//  Choice "1".
                case "1":
                    if (!locationOne) {
                        System.out.println("First time here");
                        locationOne = true;
                        keyHalfOne = true;
                    } else {
                        System.out.println("Been here before");
                    }
                    break;

//  Choice "2".
                case "2":
                    if (!locationTwo) {
                        System.out.println("First time here");
                        locationTwo = true;
                        keyHalfTwo = true;
                    } else {
                        System.out.println("Been here before");
                    }
                    break;

//  Choice "3".
                case "3":
                    if (keyHalfOne && keyHalfTwo) {
                        if (!locationThree) {
                            System.out.println("First time here");
                            locationThree = true;
                        } else {
                            System.out.println("Been here before");
                        }
                    } else {
                        System.out.println("not allowed");
                    }
                    break;

//  Choice "4".
                case "4":
                    System.out.println("Goodbye.");
                    return;

//  Out of parameters choice.
                default:
                    System.out.println("Try again.");
            }
//  If statement to handle if all three locations have been visited.
            if (locationOne && locationTwo && locationThree) {
                System.out.println("You went to all three!");
                break;
            }
        }
    }
}