

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
