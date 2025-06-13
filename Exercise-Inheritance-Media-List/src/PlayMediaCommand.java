import java.util.List;

public class PlayMediaCommand {
    //- Handles playing selected media.
    public void execute(TerminalUtils terminalUtils, MediaService mediaService) {
        //- Checking if mediaList is empty and returning if so.
        if (mediaService.isEmpty()) {
            terminalUtils.displayMessage("No media to play.");
            return;
        }
        //- Displaying mediaList to the user to help navigate input.
        List<Media> mediaList = mediaService.getAllMedia();
        terminalUtils.displayMediaList(mediaList);
        //- Getting the Integer from user to help navigate.
        int choice = terminalUtils.getInt("Enter the index of the Media you would like to play: ");
        //- If statement used to compare to user input and navigate properly.
        if (choice > 0 && choice <= mediaList.size()) {
            mediaList.get(choice - 1).play();
        } else {
            terminalUtils.displayMessage("Invalid selection.");
        }
    }
}
