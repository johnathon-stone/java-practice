public class Image extends Media {
    //- Dimensions in String for Image.
    private String dimensions;
    //- FileFormat in String for Image.
    private String fileFormat;

    //- Setter for Image.
    public Image(String name, String dimension, String fileFormat) {
        super(name);
        this.dimensions = dimension;
        this.fileFormat = fileFormat;
    }

    //- Getter to return an instance of dimensions.
    public String getDimensions() {
        return dimensions;
    }

    //- Getter to return an instance of fileFormat.
    public String getFileFormat() {
        return fileFormat;
    }

    //- Inherited method play from media formated for image.
    @Override
    public void play() {
        System.out.println("Displaying image '" + name + "' using image viewing software.");
    }

    //- Inherited method getDescription from media formated for image.
    @Override
    public String getDescription() {
        return "\nDescription: Image '" + name + "' - Dimensions: " + dimensions + ", File format: " + fileFormat;
    }
}
