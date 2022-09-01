package HW_18_Polymorph;

public class PopMusic extends MusicStyles{
    PopMusic() {
        this.songs = new String[]{"Twenty One Pilots: Stressed Out", "Ed Sheeran: Bad habits", "Sam Smith: Stay with me"};
    }

    @Override
    void playMusic() {
        System.out.println("Now u can listen pop-music play list: ");
        for (String song : songs) {
            System.out.println(song);
        }
        System.out.println();
    }
}
