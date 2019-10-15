package OOP_Project1;

/**
 * The AudioPlayer class holds the 4 methods that are unique to all Audio Players. Along with a constructor called
 * AudioPlayer that accepts 4 parameters and calls its parent classes constructor while setting the item type to Audio.
 * The AudioPlayer class also has a toString method that calls its parent toString method + a few new values.
 * @author Christopher Thorn
 */
public class AudioPlayer extends Product implements MultimediaControl {
    private String supportedAudioFormats;
    private String supportedPlaylistFormats;

    @Override
    public void play() {
    System.out.println("Playing");
    }

    @Override
    public void stop() {
    System.out.println("Stopping");
    }

    @Override
    public void previous() {
        System.out.println("Previous");
    }

    @Override
    public void next() {
        System.out.println("Next");
    }

    /**
     * The toString method calls and displays the parents toString method with the keyword "super" along with displaying
     * supportedAudioFormats and supportedPlaylistFormats.
     * @return the products toString method along with supportedAudioFormats + supportedPlaylistFormats.
     */
    public String toString(){

        return super.toString() + "\nsupported Audio Formats: "+ supportedAudioFormats
                + "\nsupported playlist formats: "+ supportedPlaylistFormats;
    }


    /**
     * AudioPlayer constructor accepts 4 parameters (name, manufacturer, supportedAudioFormats and
     * supportedPlaylistFormats). It then calls its parent constructor in the Product class and sets the item type to
     * type "AUDIO".After that it declares 2 variables.
     * @param name The name of the product .
     * @param manufacturer The company who makes the product.
     * @param supportedAudioFormats The type of audio formats that the product will support.
     * @param supportedPlaylistFormats The type of playlists that the product will support.
     */
   AudioPlayer(String name, String manufacturer,String supportedAudioFormats,String supportedPlaylistFormats){
        super(name, manufacturer,ItemType.AUDIO);
        this.supportedPlaylistFormats = supportedPlaylistFormats;
        this.supportedAudioFormats = supportedAudioFormats;
    }
}
