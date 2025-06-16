public class Video extends Media {
    //- Duration in Integer for Video.
    private final int duration;
    //- Resolution in String for Video.
    private final String resolution;

    //- Setter for Video.
    public Video(String name, int duration, String resolution) {
        super(name);
        this.duration = duration;
        this.resolution = resolution;
    }

    //- Getter to return an instance of duration
    public int getDuration() {
        return duration;
    }

    //- Getter to return an instance of resolution
    public String getResolution() {
        return resolution;
    }

    //- Inherited method play from media formated for video
    @Override
    public void play() {
        System.out.println("Playing video '" + name + "' using video player software.");
    }

    //- Inherited method getDescription from media formated for video
    @Override
    public String getDescription() {
        return "\nDescription: Video '" + name + "' - Duration: " + duration + " minutes, Resolution: "  + resolution;
    }
}
