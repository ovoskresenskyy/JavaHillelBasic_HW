package HW_7_ShuttleNumbers;

public class MainApp {
    public static void main(String[] args) {

        int unluckyNumber1 = 4;
        int unluckyNumber2 = 9;
        int shuttleNumber = 1;

        for (int i = 0; i < 100; shuttleNumber++) {

            if (shuttleNumber / 10 != unluckyNumber1
                    && shuttleNumber / 10 != unluckyNumber2
                    && shuttleNumber % 10 != unluckyNumber1
                    && shuttleNumber % 10 != unluckyNumber2
                    && shuttleNumber % 100 != unluckyNumber1 // for double figures
                    && shuttleNumber % 100 != unluckyNumber2 // for double figures
                    && shuttleNumber % 100 / 10 != unluckyNumber1
                    && shuttleNumber % 100 / 10 != unluckyNumber2) {

                System.out.println(shuttleNumber);
                i++;
            }
        }
    }
}

