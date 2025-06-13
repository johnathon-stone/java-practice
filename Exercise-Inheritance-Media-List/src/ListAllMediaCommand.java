public class ListAllMediaCommand {
    //- Handles displaying all media.
    public void execute(TerminalUtils terminalUtils, MediaService mediaService) {
        terminalUtils.displayMediaList(mediaService.getAllMedia());
    }
}
