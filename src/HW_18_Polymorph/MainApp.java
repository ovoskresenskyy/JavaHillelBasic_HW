package HW_18_Polymorph;

public class MainApp {
    public static void main(String[] args) {
        MusicStyles[] musicSongs = {new RockMusic(), new PopMusic(), new ClassicMusic()};

        for (MusicStyles musicSong: musicSongs) {
            musicSong.playMusic();
        }
    }
}
