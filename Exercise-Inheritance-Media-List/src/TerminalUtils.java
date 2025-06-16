import java.util.Scanner;
import java.util.List;

public class TerminalUtils {
    Scanner input = new Scanner(System.in);

    //- Shows the main menu options.
    public void displayMenu() {
        displayMessage("=== Media List Application ===");
        displayMessage("1. Add Media\n2. Remove Media\n3. Play Media\n4. List All Media\n5. Quit");
    }

    //- Gets string input with prompt.
    public String getString(String prompt) {
        while (true) {
            displayMessage(prompt);
            String userInputSTR = input.nextLine();
            if (userInputSTR.trim().isEmpty()){
                displayMessage("Invalid input, try again.");
            } else return userInputSTR;
        }
    }

    //- Gets integer input with prompt and validation.
    public int getInt(String prompt) {
        while (true) {
            try {
                displayMessage(prompt);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                displayMessage("Invalid input, try again.");
            }
        }
    }

    //- Displays messages to user.
    public void displayMessage(String message) {
        System.out.println(message);
    }

    //- Formats and displays media list.
    public void displayMediaList(List<Media> mediaList) {
        if (mediaList.isEmpty()) {
            displayMessage("No media available.");
            return;
        }
        displayMessage("===All Media in Library===");
        for (int i = 0; i < mediaList.size(); i++) {
            System.out.println((i + 1) + ". " + mediaList.get(i).getName() + mediaList.get(i).getDescription());
        }
    }
}
