

// Target interface
interface MediaPlayers {
    void play(String audioType, String fileName);
}

// Adaptee
class AdvancedMediaPlayers {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}


// Adapter
class MediaAdapters implements MediaPlayers {
    AdvancedMediaPlayers advancedMusicPlayer;

    public MediaAdapters(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new AdvancedMediaPlayers();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new AdvancedMediaPlayers();
        }
    }
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}


// Concrete class implementing the target interface
class AudioPlayers implements MediaPlayers {
    MediaAdapters mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapters(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayers audioPlayer = new AudioPlayers();
        audioPlayer.play("mp3", "Despacito");
        audioPlayer.play("mp4", "Transformer");
        audioPlayer.play("vlc", "Dynamite");
        audioPlayer.play("avi", "Let Me Down");
    }
}