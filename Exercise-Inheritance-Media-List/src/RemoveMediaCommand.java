public class RemoveMediaCommand {
    //- Handles removing media from list.
    public void execute(TerminalUtils terminalUtils, MediaService mediaService) {
        //- Checking if mediaList is empty and returning if so.
        if (mediaService.isEmpty()) {
            terminalUtils.displayMessage("No media to remove.");
            return;
        }
        //- Displaying mediaList to the user to help navigate input.
        terminalUtils.displayMediaList(mediaService.getAllMedia());
        String name = terminalUtils.getString("Enter the name of the Media you would like to remove: ");
        //- Using if to control the output based off the users input.
        if (mediaService.removeMedia(name)) {
            terminalUtils.displayMessage("Media removed successfully.");
        } else {
            terminalUtils.displayMessage("Media not found.");
        }
    }
}
