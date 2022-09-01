package HW_6_CounterStrike;

public class MainApp {
    public static void main(String[] args) {

        String team1 = "Natus Vincere";
        double playerTeam1_electroNic = 25;
        double playerTeam1_sdy = 24;
        double playerTeam1_s1mple = 17;
        double playerTeam1_b1t = 14;
        double playerTeam1_Perfecto = 13;

        double team1Average = (playerTeam1_electroNic + playerTeam1_sdy + playerTeam1_s1mple + playerTeam1_b1t + playerTeam1_Perfecto) / 5;

        String team2 = "FaZe";
        double playerTeam2_Twistzz = 25;
        double playerTeam2_rain = 23;
        double playerTeam2_karrigan = 19;
        double playerTeam2_broky = 18;
        double playerTeam2_ropz = 12;

        double team2Average = (playerTeam2_Twistzz + playerTeam2_rain + playerTeam2_karrigan + playerTeam2_broky + playerTeam2_ropz) / 5;

        if (team1Average > team2Average) {
            System.out.println("Winner: " + team1 + " with average " + team1Average + " frags");
        } else if (team1Average < team2Average) {
            System.out.println("Winner: " + team2 + " with average " + team2Average + " frags");
        } else {
            System.out.println("Friendship won");
        }


    }
}

