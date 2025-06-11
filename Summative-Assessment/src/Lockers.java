import java.util.Arrays;
import java.util.Random;

public class Lockers {
    private static final int maxLockers = 10;
    private static final String[] lockers = new String[maxLockers];

    /*Fills the lockers[] with null values.*/
    public static void startLockers() {
        Arrays.fill(lockers, null);
    }

    /*Method to check if there is unrented lockers and adjust the menu accordingly.*/
    public static boolean rentAvailability() {
        for (int i = 0; i < lockers.length; i++) {
            String locker = lockers[i];
            if (locker == null) {
                return true;
            }
        }
        return false;
    }

    /*Starts going through the lockers[] until it finds a null value or reaches the end.*/
    public static int nextAvailableLocker() {
        for (int i = 0; i < lockers.length; i++) {
            String locker = lockers[i];
            if (locker == null) {
                return i;
            }
        }
        return -1;
    }

    /*Uses the user input - 1 to check if the value associated with it on the index is null or not with exception handling.*/
    public static boolean isRented(int lockerNum) {
        try {
            if (lockers[lockerNum - 1] == null) {
                IO.notRented();
                return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid locker number. Please enter a valid locker number.");
            return false;
        }
    }

    /*Gets the value assigned at a specific point in the index.*/
    public static String getPin(int index) {
        return lockers[index];
    }

    /*Method used to validate the pin from user input against the value in lockers[].*/
    public static void validatePin(String currentPin) {
        while (true) {
            String pinGuess = IO.enterPin();
            if (currentPin.equals(pinGuess)) {
                IO.accessGranted();
                break;
            } else {
                IO.wrongPin();
            }
        }
    }

    /*Method used to validate the pin from user input against the value in lockers[].*/
    public static void validatePinForRelease(int requestedLockerNum, String currentPin) {
        while (true) {
            String pinGuess = IO.enterPin();
            if (currentPin.equals(pinGuess)) {
                boolean resetPinCheck = IO.releaseConfirmation();
                if (resetPinCheck) {
                    resetPin(requestedLockerNum);
                    break;
                }
                break;
            } else IO.wrongPin();
        }
    }

    /*Method used to generate pins when renting a locker and assign them within lockers[]*/
    public static void genPin() {
        int lockerNum = nextAvailableLocker();
        if (lockerNum < 0 || lockerNum > lockers.length) {
            IO.noAvailableLocker();
        } else {
            int randomNum = new Random().nextInt(10000);
            lockers[lockerNum] = String.format("%04d", randomNum);
            IO.yourAssignedLocker(lockerNum);
        }
    }

    /*Method used to reset the value(pin) within a specific index of the lockers[].*/
    public static void resetPin(int requestedLockerNum) {
        lockers[requestedLockerNum] = null;
    }
}
