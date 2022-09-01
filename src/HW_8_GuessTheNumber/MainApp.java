package HW_8_GuessTheNumber;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        int randomNumber = (int)(Math.random() * 11);
        int triesLeft = 3;
        int insertNumber = 0;
        boolean correctTry = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Try to guess the number from 0 to 10.");
        System.out.println("You will have 3 tries.");

        while (triesLeft != 0 && !correctTry) {
            insertNumber = scan.nextInt();

            if (insertNumber == randomNumber) {
                correctTry = true;
            } else {
                System.out.println("Sad but wrong. Tries left: " + --triesLeft);
            }
        }

        if (correctTry) {
            System.out.println("Success! You won!");
        } else {
            System.out.println("You lose.");
        }

        System.out.println("randomNumber = " + randomNumber);
    }
}
