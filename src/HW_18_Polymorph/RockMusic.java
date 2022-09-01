package HW_18_Polymorph;

public class RockMusic extends MusicStyles {
    RockMusic() {
        this.songs = new String[]{"Queen: Bohemian Rhapsody",
                "Eagles: Hotel California",
                "Nirvana: Smells Like Teen Spirit",
                "Scorpions: Wind of Change"};
    }

    @Override
    void playMusic() {
        System.out.println("Now u can listen some of the best rock songs: ");
        for (String song : songs) {
            System.out.println(song);
        }
        System.out.println();
    }
}
