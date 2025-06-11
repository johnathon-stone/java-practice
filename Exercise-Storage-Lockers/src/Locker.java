public class Locker {

    private String lockerId;
    private boolean isOccupied;
    private String contents;

    //  Locker(String lockerId): Constructor that initializes the locker with a given ID, sets isOccupied to false, and contents to an empty string.
    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.isOccupied = false;
        this.contents = "";
    }

    // Getter
    public String getLockerId() {
        return lockerId;
    }

    // void storeItem(String item): Stores an item in the locker, sets isOccupied to true, and updates the contents.
    public void storeLockerItem(String item) {
        if (!isOccupied) {
            contents = item;
            isOccupied = true;
            System.out.println("Item stored.");
        } else {
            System.out.println("Locker is already full.");
        }
    }

    // void removeItem(): Empties the locker, sets isOccupied to false, and clears the contents.
    public void removeLockerItem(String lockerId) {
        if (isOccupied) {
            contents = "";
            isOccupied = false;
            System.out.println("Item removed.");
        } else {
            System.out.println("Locker is already empty.");
        }
    }

    // String toString(): Returns a string representation of the locker, including its ID, occupancy status, and contents.
    public String toString() {
        return "LockerID: " + this.lockerId + ", Occupied status: " + this.isOccupied + ", Contents: " + this.contents;
    }
}
