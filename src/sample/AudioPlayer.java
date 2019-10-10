package sample;

import javax.xml.namespace.QName;

class AudioPlayer extends Product implements MultimediaControl {
    String supportedAudioFormats;
    String supportedPlaylistFormats;

    @Override
    public void play() {

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
   /public AudioPlayer(String name, String manufacturer,String supportedAudioFormats,String supportedPlaylistFormats){
        super(name, manufacturer, supportedAudioFormats, supportedPlaylistFormats);

}

    }
}
