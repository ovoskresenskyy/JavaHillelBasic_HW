package HW_9_Rugby;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        int[] teamA = new int[25];
        int[] teamB = new int[25];

        int minAge = 18;
        int maxAge = 41;

        int sumAgeTeamA = 0;
        int sumAgeTeamB = 0;

        for (int i = 0; i < 25; i++) {
            teamA[i] = (int) ((Math.random() * (maxAge-minAge)) + minAge);
            teamB[i] = (int) ((Math.random() * (maxAge-minAge)) + minAge);

            sumAgeTeamA += teamA[i];
            sumAgeTeamB += teamB[i];
        }

        System.out.println("Age of team A players = " + Arrays.toString(teamA));
        System.out.println("Age of team B players = " + Arrays.toString(teamB));

        System.out.println("Average age of team A players = " + sumAgeTeamA / teamA.length);
        System.out.println("Average age of team B players = " + sumAgeTeamB / teamB.length);

    }
}
