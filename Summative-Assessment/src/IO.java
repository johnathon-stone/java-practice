import java.util.Scanner;

public class IO {
    private static final Scanner input = new Scanner(System.in);

    /*Method to capture user String input and return it.*/
    public static String getInput() {
        return input.nextLine();
    }

    /*Method to print a menu to ease user accessibility.*/
    public static void displayMenu() {
        if (Lockers.rentAvailability()) {
            System.out.println("\n------Locker Menu------");
            System.out.println("1. Rent a locker\n2. Access a locker\n3. Release a locker");
            System.out.println("-----------------------");
            System.out.println("What would you like to do?");
        } else {
            System.out.println("\n------Locker Menu------");
            System.out.println("2. Access a locker\n3. Release a locker");
            System.out.println("-----------------------");
            System.out.println("What would you like to do?");
        }

    }

    /*Method to close the program.*/
    public static void exitProgram() {
        System.out.println("Thank you for using our locker service. Goodbye!");
        System.exit(0);
    }

    /*Method to request user input of a locker number with exception handling.*/
    public static int requestLockerNumber() {
        while (true) {
            System.out.println("Enter a locker number you would like to access: ");
            try {
                int index = Integer.parseInt(input.nextLine());
                if (Lockers.isRented(index)){
                    return (index - 1);
                }
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid locker number.");
            }
        }
    }

    /*Method used print an instance based string.*/
    public static void noAvailableLocker() {
        System.out.println("No available lockers.");
    }

    /*Method used print a string with the index + 1 and assigned value(pin).*/
    public static void yourAssignedLocker(int lockerNumber) {
        System.out.println("You were assigned Locker#: " + (lockerNumber + 1) + " With a pin of: " + Lockers.getPin(lockerNumber));
    }

    /*Method used to print a string that the locker at the index they specified isn't rented.*/
    public static void notRented() {
        System.out.println("That locker is not rented. Try again.");
    }

    /*Method used to initiate getting user input for the value(pin) assigned.*/
    public static String enterPin() {
        System.out.println("Enter your 4 digit pin:");
        return input.nextLine();
    }

    /*Method used to print confirmation of successful entry and validation of the specific value(pin) in lockers[].*/
    public static void accessGranted() {
        System.out.println("Success! Lock it up when you're done.");
    }

    /*Method used to print a statement letting the user know there input is incorrect.*/
    public static void wrongPin() {
        System.out.println("Incorrect PIN. Access denied. Try again.");
    }

    /*Method that prints a statement requesting user confirmation and validation based on input.*/
    public static boolean releaseConfirmation() {
        System.out.println("Are you sure? (y/n)");
        String closeDecision = input.nextLine();
        if ("y".equalsIgnoreCase(closeDecision)) {
            System.out.println("Success! Locker made available and PIN set to null.");
            return true;
        } else System.out.println("The locker has not been released.");
        return false;
    }
}
