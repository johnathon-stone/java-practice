import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LockerManager manager = new LockerManager();


        System.out.println("Welcome to the Storage Locker Manager!");

        while (true) {
            System.out.println("1. Add Locker\n2. Remove Locker\n3. Store Item\n4. Retrieve Item\n5. Display All Lockers\n6. Exit");
            System.out.println("Choose an option: ");

            switch (input.nextLine()) {
                case "1":
                    System.out.println("Enter a locker ID: ");
                    manager.addLocker(input.nextLine());
                    break;
                case "2":
                    System.out.println("Enter a locker ID: ");
                    manager.removeLocker(input.nextLine());
                    break;
                case "3":
                    System.out.println("Enter a locker ID: ");
                    manager.storeItem(input.nextLine());
                    break;
                case "4":
                    System.out.println("Enter a locker ID: ");
                    manager.removeItem(input.nextLine());
                    break;
                case "5":
                    System.out.println("|----------------Current list of Lockers----------------|");
                    manager.displayAllLockers();
                    break;
                case "6":
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;

            }
        }
    }
}