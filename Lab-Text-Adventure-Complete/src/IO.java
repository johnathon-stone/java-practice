import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    Scanner input = new Scanner(System.in);

    /*Added a method to capture and gathering user input.*/
    public int getInput() {
        while (true) {
            try {
                int choice = Integer.parseInt(input.nextLine());
                if (choice > 0 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Invalid input. Enter an integer from 1-6 please.");
                }
            /*Added exception handling to manage invalid numeric input.*/
            } catch (Exception e) {
                System.out.println("Error: " + e + " Please enter an integer from 1-6.");
            }
        }
    }

    /*Adding a method to display repetitive code*/
    public void displayMenu() {
        System.out.println("\nChoose where you would like to go: ");
        System.out.println("(1) The Whispering Forest.");
        System.out.println("(2) Ashfang Ridge.");
        System.out.println("(3) Siltmirror Marsh.");
        System.out.println("(4) Atlantis.");
        System.out.println("(5) The Crystal Throne");
        System.out.println("(6) to Exit.");
    }

    public void stringProcessor(String[] strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public void beenThere() {
        System.out.println("You remember that you've been here before and found half of a key last time");
    }
}
