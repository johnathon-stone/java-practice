import java.util.ArrayList;
import java.util.List;

//- Class to manage the media collection:
public class MediaService {

    //- Establishing mediaList to hold all the Media.
    private final List<Media> mediaList = new ArrayList<>();

    //- Adds media to the list.
    public void addMedia(Media media) {
        mediaList.add(media);
    }

    //- Removes media by name, returns boolean success.
    public boolean removeMedia(String name) {
        Media mediaToRemove = findMediaByName(name);
        if (mediaToRemove != null) {
            return mediaList.remove(mediaToRemove);
        }
        return false;
    }

    //- Finds and returns media by name.
    public Media findMediaByName(String name) {
        for (int i = 0; i < getMediaCount(); i++) {
            if (mediaList.get(i).getName().equalsIgnoreCase(name)) {
                return mediaList.get(i);
            }
        }
        return null;
    }

    //- Returns copy of media list.
    public List<Media> getAllMedia() {
        return new ArrayList<>(mediaList);
    }

    //- Returns number of media items.
    public int getMediaCount() {
        return mediaList.size();
    }

    //- Checks if list is empty.
    public boolean isEmpty() {
        return mediaList.isEmpty();
    }
}
