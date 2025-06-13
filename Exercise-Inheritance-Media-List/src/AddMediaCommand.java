public class AddMediaCommand {
    // - Handles adding new media, be sure to first prompt for the media type and
    //   collect all the data specific to that type(e.g. Videos will have different inputs than audio or books).
    public void execute(TerminalUtils terminalUtils, MediaService mediaService) {

        terminalUtils.displayMessage("===Media types list===");
        terminalUtils.displayMessage("1. Audio\n2. Book\n3. Image\n4. Video");
        int choice = terminalUtils.getInt("What type of media will you be adding?");
        String name = terminalUtils.getString("Enter the name: ");

        switch (choice) {
            case 1 -> {
                int duration = terminalUtils.getInt("Enter the duration of the audio in minutes: ");
                String artist = terminalUtils.getString("Enter the name of the artist: ");
                mediaService.addMedia(new Audio(name, duration, artist));
            }
            case 2 -> {
                String author = terminalUtils.getString("Enter the name of the author: ");
                int pageCount = terminalUtils.getInt("Enter the page count of the book: ");
                mediaService.addMedia(new Book(name, author, pageCount));
            }
            case 3 -> {
                String dimension = terminalUtils.getString("Enter the dimensions of the image: ");
                String fileFormat = terminalUtils.getString("Enter the file format of the image: ");
                mediaService.addMedia(new Image(name, dimension, fileFormat));
            }
            case 4 -> {
                int duration = terminalUtils.getInt("Enter the duration in minutes of the video: ");
                String resolution = terminalUtils.getString("Enter the resolution of the video: ");
                mediaService.addMedia(new Video(name, duration, resolution));
            }
            default -> terminalUtils.displayMessage("Invalid media selection. Please try again!");
        }
        terminalUtils.displayMessage("Media: " + name + " was added successfully.");
    }
}
