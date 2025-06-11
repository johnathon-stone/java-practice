import java.util.ArrayList;
import java.util.Scanner;

public class LockerManager {
    Scanner input = new Scanner(System.in);
    // lockers (ArrayList<Locker>): A list to store multiple Locker objects.
    private ArrayList<Locker> lockers;

    // LockerManager(): Constructor that initializes the list of lockers.
    public LockerManager() {
        this.lockers = new ArrayList<>();
    }

    // void addLocker(String lockerId): Adds a new locker to the list.
    public void addLocker(String lockerId) {
        Locker locker = new Locker(lockerId);
        this.lockers.add(locker);
    }

    // Locker getLocker(String lockerId): Retrieves a locker by its ID
    public Locker getLocker(String lockerId) {
        for (Locker locker : lockers) {
            if (locker.getLockerId().equals(lockerId)) {
                return locker;
            }
        }
        System.out.println("Locker not found.");
        return null;
    }

    // void removeLocker(String lockerId): Removes a locker from the list by its ID.
    public void removeLocker(String lockerId) {
        Locker locker = getLocker(lockerId);
        if (locker != null) {
            this.lockers.remove(locker);
            System.out.println("Locker removed successfully.");
        }
    }

    // storeItem
    public void storeItem(String lockerId) {
        Locker locker = getLocker(lockerId);
        if (locker != null) {
            System.out.println("What would you like to store? ");
            locker.storeLockerItem(input.nextLine());
        }
    }

    // removeItem
    public void removeItem(String lockerId) {
        Locker locker = getLocker(lockerId);
        if (locker != null) {
            locker.removeLockerItem(lockerId);
        }
    }

    // void displayAllLockers(): Displays information for all lockers.
    public void displayAllLockers() {
        for (Locker locker : lockers) {
            System.out.println(locker.toString());
        }
    }
}
