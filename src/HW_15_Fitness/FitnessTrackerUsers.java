package HW_15_Fitness;

public class FitnessTrackerUsers {
    public static void main(String[] args) {

        fitnessTrackers user1 = new fitnessTrackerXiaomi("James",
                "Smith",
                "james.smith@gmail.com",
                "0501234567",
                4,
                7,
                1986,
                92,
                140,
                80,
                500);

        fitnessTrackers user2 = new fitnessTrackerXiaomi("Mary",
                "Johnson",
                "mary.johsnon@gmail.com",
                "0607654321",
                31,
                12,
                2000,
                45,
                120,
                80,
                10000);

        fitnessTrackers user3 = new fitnessTrackerHuawei("John",
                "Williams",
                "john.williams@gmail.com",
                "0709876543",
                24,
                8,
                1991,
                90,
                190,
                110,
                90,
                7300);

        fitnessTrackers user4 = new fitnessTrackerHuawei("Patricia",
                "Brown",
                "patricia.brown@gmail.com",
                "088147852",
                8,
                3,
                1960,
                59,
                165,
                160,
                110,
                300);

        fitnessTrackers user5 = new fitnessTrackerNoName("David",
                "Jones",
                "david.jones@gmail.com",
                "0887776655",
                1,
                1,
                2000,
                120,
                170,
                120,
                300);

        user1.printAccountInfo();
        user2.printAccountInfo();
        user3.printAccountInfo();
        user4.printAccountInfo();
        user5.printAccountInfo();

        user1.setStepsPerDay(5500);
        user1.setPressure(120, 70);

        user3.setSurName("Incognito");
        user3.setStepsPerDay(17000);
        user3.setWeight(65);

        user1.printAccountInfo();
        user3.printAccountInfo();
    }
}

