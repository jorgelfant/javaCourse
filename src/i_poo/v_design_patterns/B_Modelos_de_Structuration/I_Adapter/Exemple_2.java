package i_poo.v_design_patterns.B_Modelos_de_Structuration.I_Adapter;

public class Exemple_2 {
  public static void main(String[] args) {
//==================================================================================================================
//                            5) Use the AudioPlayer to play different types of audio formats.
//==================================================================================================================
    AudioPlayer audioPlayer = new AudioPlayer();

    audioPlayer.play("mp3", "beyond the horizon.mp3");
    audioPlayer.play("mp4", "alone.mp4");
    audioPlayer.play("vlc", "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
    /*
    Resultado:
       Playing mp3 file. Name: beyond the horizon.mp3
       Playing mp4 file. Name: alone.mp4
       Playing vlc file. Name: far far away.vlc
       Invalid media. avi format not supported
    */
  }
}

//==================================================================================================================
//                                             Adapter Pattern
//==================================================================================================================
    /*
    Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under
    structural pattern as this pattern combines the capability of two independent interfaces.

    This pattern involves a single class which is responsible to join functionalities of independent or incompatible
    interfaces. A real life example could be a case of card reader which acts as an adapter between memory card and
    a laptop. You plugin the memory card into card reader and card reader into the laptop so that memory card can be
    read via laptop.

    We are demonstrating use of Adapter pattern via following example in which an audio player device can play mp3
    files only and wants to use an advanced audio player capable of playing vlc and mp4 files.
    */
//==================================================================================================================
//                                             Implementation
//==================================================================================================================
    /*
    We have a MediaPlayer interface and a concrete class AudioPlayer implementing the MediaPlayer interface.
    AudioPlayer can play mp3 format audio files by default.

    We are having another interface AdvancedMediaPlayer and concrete classes implementing the AdvancedMediaPlayer
    interface. These classes can play vlc and mp4 format files.

    We want to make AudioPlayer to play other formats as well. To attain this, we have created an adapter class
    MediaAdapter which implements the MediaPlayer interface and uses AdvancedMediaPlayer objects to play the required
    format.

    AudioPlayer uses the adapter class MediaAdapter passing it the desired audio type without knowing the actual class
    which can play the desired format. AdapterPatternDemo, our demo class will use AudioPlayer class to play
    various formats.

                                                                                     Interface
                                                                                  -----------------                                 -----------------
                                                                                  | MediaPlayer   |                                 |        Exemple_1   |
                                                                                  -----------------                                 -----------------
                                                                                  | + play():void |                                 | + main():void |
                                                                                  -----------------                                 -----------------
                                                                                         /\                                                    |
                                                                              implements | implements                                          |
--------------------------------------------------------                                 |                                               uses  |
|                 -----------------------              |           --------------------------------------------                                |
|                 | AdvancedMediaPlayer |              |           |                                           |                               |
|                 -----------------------              |           |                                           |                               |
|                 | + playVlc(): void   |              |      --------------------------------------------   -------------------------------   |
|                 | + playMp4(): void   |              |      |               MediaAdapter               |   | AudioPlayer                 |   |
|                 -----------------------              | uses --------------------------------------------   -------------------------------   |
|                           /\                         |<-----|-advancedMediaPlayer: AdvancedMediaPlayer |   | -mediaAdapter: MediaAdapter | <--
|                           |                          |      --------------------------------------------   -------------------------------
|                           |                          |      | +MediaAdapter(); void                    |   | +play() : void              |
|                   -----------------                  |      | +play(): void                            |   -------------------------------
|                   |               |                  |      --------------------------------------------
|                   |               |                  |
|  ---------------------        ---------------------  |
|  |   VlcPlayer       |        |   Mp4Player       |  |
|  ---------------------        ---------------------  |
|  | + playVlc(): void |        | + playVlc(): void |  |
|  | + playMp4(): void |        | + playMp4(): void |  |
|  ---------------------        ---------------------  |
|                                                      |
--------------------------------------------------------
    */

//==================================================================================================================
//                            1) Create interfaces for Media Player and Advanced Media Player.
//==================================================================================================================

//MediaPlayer.java

interface MediaPlayer {
 public void play(String audioType, String fileName);
}

//AdvancedMediaPlayer.java

interface AdvancedMediaPlayer {
  public void playVlc(String fileName);
  public void playMp4(String fileName);
}

//==================================================================================================================
//                            2) Create concrete classes implementing the AdvancedMediaPlayer interface.
//==================================================================================================================
 class VlcPlayer implements AdvancedMediaPlayer {
  @Override
  public void playVlc(String fileName) {
    System.out.println("Playing vlc file. Name: "+ fileName);
  }

  @Override
  public void playMp4(String fileName) {
    //do nothing
  }
}

//------------------------------------------------------------------
 class Mp4Player implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    //do nothing
  }

  @Override
  public void playMp4(String fileName) {
    System.out.println("Playing mp4 file. Name: "+ fileName);
  }
}

//==================================================================================================================
//                            3) Create adapter class implementing the MediaPlayer interface
//==================================================================================================================
 class MediaAdapter implements MediaPlayer {

  AdvancedMediaPlayer advancedMusicPlayer;//esto seria el architecto de ejemplo 1 es decir una clase a parte que usamos pa usar sus metodos

  public MediaAdapter(String audioType){

    if(audioType.equalsIgnoreCase("vlc") ){
      advancedMusicPlayer = new VlcPlayer();

    }else if (audioType.equalsIgnoreCase("mp4")){
      advancedMusicPlayer = new Mp4Player();
    }
  }

  @Override
  public void play(String audioType, String fileName) {

    if(audioType.equalsIgnoreCase("vlc")){
      advancedMusicPlayer.playVlc(fileName);
    }
    else if(audioType.equalsIgnoreCase("mp4")){
      advancedMusicPlayer.playMp4(fileName);
    }
  }
}

//==================================================================================================================
//                            4) Create concrete class implementing the MediaPlayer interface.
//==================================================================================================================
 class AudioPlayer implements MediaPlayer {
  MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {

    //inbuilt support to play mp3 music files
    if(audioType.equalsIgnoreCase("mp3")){
      System.out.println("Playing mp3 file. Name: " + fileName);
    }

    //mediaAdapter is providing support to play other file formats
    else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    }

    else{
      System.out.println("Invalid media. " + audioType + " format not supported");
    }
  }
}

