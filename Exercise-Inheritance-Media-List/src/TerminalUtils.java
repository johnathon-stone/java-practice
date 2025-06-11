import java.util.Scanner;

public class TerminalUtils {
    Scanner input = new Scanner(System.in);

    //- shows the main menu options
    public void displayMenu() {
        System.out.println("=== Media List Application ===");
        System.out.println("1. Add Media\n2. Remove Media\n3. Play Media\n4. List All Media\n5. Quit");
        System.out.println("Choose an option: ");
    }

    //- gets and validates menu selection
    public void getMenuChoice() {
        return String menuChoice = input.nextLine();
    }

    //- gets string input with prompt
    public void getString(String prompt) {

    }

    //- gets integer input with prompt and validation
    public void getInt(String prompt) {

    }

    //- displays messages to user
    public void displayMessage(String message) {

    }

    //- formats and displays media list
    public void displayMediaList(List<Media> mediaList) {

    }

}
