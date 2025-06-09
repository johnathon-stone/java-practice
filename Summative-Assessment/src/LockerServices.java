public class LockerServices {

    /*Method used to handle the main menu functionality with user input.*/
    public static void menuRedirection() {
        while (true) {
            IO.displayMenu();

            String choice = IO.getInput();
            if (Lockers.rentAvailability()) {
                switch (choice) {
                    case "1":
                        rentLocker();
                        break;
                    case "2":
                        accessLocker();
                        break;
                    case "3":
                        releaseLocker();
                        break;
                    default:
                        IO.exitProgram();
                        break;
                }
            } else {
                switch (choice) {
                    case "1":
                        rentLocker();
                        break;
                    case "2":
                        accessLocker();
                        break;
                    case "3":
                        releaseLocker();
                        break;
                    default:
                        IO.exitProgram();
                        break;
                }
            }
        }
    }


    /*Method used to rent lockers and return a 4 digit pin.*/
    public static void rentLocker() {
        Lockers.genPin();
    }

    /*Method used to access a specific locker within the lockers[].*/
    public static void accessLocker() {
        int requestedLockerNum = IO.requestLockerNumber();
        String currentPin = String.valueOf(Lockers.getPin(requestedLockerNum));
        Lockers.validatePin(currentPin);
    }

    /*Method used to release a specific locker within the lockers[]. */
    public static void releaseLocker() {
        int requestedLockerNum = IO.requestLockerNumber();
        String currentPin = String.valueOf(Lockers.getPin(requestedLockerNum));
        Lockers.validatePinClosure(requestedLockerNum, currentPin);
    }
}

