public class Main {
    public static void main(String[] args) {

        /*Calls startLockers() to initializes the lockers[] and assign null values.*/
        Lockers.startLockers();

        /*Start the program loop.*/
        while (true) {
            IO.displayMenu();

            String choice = IO.getInput();
            if (Lockers.rentAvailability()) {
                switch (choice) {
                    case "1":
                        LockerServices.rentLocker();
                        break;
                    case "2":
                        LockerServices.accessLocker();
                        break;
                    case "3":
                        LockerServices.releaseLocker();
                        break;
                    default:
                        IO.exitProgram();
                }
            } else {
                switch (choice) {
                    case "1":
                        LockerServices.rentLocker();
                        break;
                    case "2":
                        LockerServices.accessLocker();
                        break;
                    case "3":
                        LockerServices.releaseLocker();
                        break;
                    default:
                        IO.exitProgram();
                }
            }
        }
    }
}