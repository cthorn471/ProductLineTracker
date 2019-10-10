package sample;

import javax.xml.namespace.QName;

class AudioPlayer extends Product implements MultimediaControl {
    String supportedAudioFormats;
    String supportedPlaylistFormats;

    @Override
    public void play() {
    System.out.println("Playing");
    }

    @Override
    public void stop() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void next() {

    }

    //AudioPlayer constructor
   public AudioPlayer(String name, String manufacturer,String supportedAudioFormats,String supportedPlaylistFormats){
        super(name, manufacturer, "AUDIO");
        this.supportedAudioFormats = supportedAudioFormats;
        this.supportedPlaylistFormats = supportedAudioFormats;


    }

}

