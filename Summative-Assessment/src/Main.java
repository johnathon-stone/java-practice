public class Main {
    public static void main(String[] args) {

        /*Calls startLockers() to initializes the lockers[] and assign null values.*/
        Lockers.startLockers();

        /*Calls on menuRedirection() to start the program loop.*/
        LockerServices.menuRedirection();
    }
}