public class Audio extends Media {
    //- Duration in Integer for Audio.
    private final int duration;
    //- Artist in String for Audio.
    private final String artist;

    //- Setter for Audio.
    public Audio(String name, int duration, String artist) {
        super(name);
        this.duration = duration;
        this.artist = artist;
    }

    //- Getter to return an instance of duration.
    public int getDuration() {
        return duration;
    }

    //- Getter to return an instance of artist.
    public String getArtist() {
        return artist;
    }

    //- Inherited method play from media formated for audio.
    @Override
    public void play() {
        System.out.println("Playing audio '" + name + "' using audio player software.");
    }

    //- Inherited method getDescription from media formated for audio.
    @Override
    public String getDescription() {
        return "\nDescription: Audio '" + name + "' - Duration: " + duration + " minutes, By: " + artist;
    }
}
