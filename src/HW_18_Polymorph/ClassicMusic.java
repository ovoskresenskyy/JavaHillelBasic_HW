package HW_18_Polymorph;

public class ClassicMusic extends MusicStyles {
    ClassicMusic() {
        this.songs = new String[]{"Mozart: Requiem", "Beethoven: Symphony No.5", "Vivaldi: The Four Seasons"};
    }

    @Override
    void playMusic() {
        System.out.println("Now u can listen classic music: ");
        for (String song : songs) {
            System.out.println(song);
        }
        System.out.println();
    }
}
