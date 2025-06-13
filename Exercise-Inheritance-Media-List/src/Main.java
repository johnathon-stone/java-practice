public class Main {
    public static void main(String[] args) {
        TerminalUtils terminalUtils = new TerminalUtils();
        MediaService mediaService = new MediaService();
        AddMediaCommand addMedia = new AddMediaCommand();
        RemoveMediaCommand removeMedia = new RemoveMediaCommand();
        PlayMediaCommand playMedia = new PlayMediaCommand();
        ListAllMediaCommand listAllMedia = new ListAllMediaCommand();

        //- While loop to continue displaying the menu and get input to navigate through the program.
        while (true) {
            terminalUtils.displayMenu();
            int choice = terminalUtils.getInt("Choose an option: ");

            //- Used a switch statement to navigate with user input along with handling input that falls outside.
            switch (choice) {
                case 1 -> addMedia.execute(terminalUtils, mediaService);
                case 2 -> removeMedia.execute(terminalUtils, mediaService);
                case 3 -> playMedia.execute(terminalUtils, mediaService);
                case 4 -> listAllMedia.execute(terminalUtils, mediaService);
                case 5 -> {
                    terminalUtils.displayMessage("Quitting the program. Thank you!");
                    System.exit(0);
                }
                default -> terminalUtils.displayMessage("Invalid input (1-5 only). Please try again!");
            }
        }
    }
}