public class LockerServices {

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

