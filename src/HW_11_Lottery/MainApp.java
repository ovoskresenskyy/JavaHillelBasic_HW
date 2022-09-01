package HW_11_Lottery;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] numbersGuessedByCompany = getRandomIntArray(7, 0, 9, true);
        int[] numbersGuessedByPlayer = getRandomIntArray(7, 0, 9, true);

        System.out.println(Arrays.toString(numbersGuessedByCompany));
        System.out.println(Arrays.toString(numbersGuessedByPlayer));
        System.out.println("Matches found: " + findMatches(numbersGuessedByCompany, numbersGuessedByPlayer));
    }

    private static int findMatches(int[] array1, int[] array2) {
        int len = Math.min(array1.length, array2.length);
        int matchesFound = 0;

        for (int i = 0; i < len; i++) {
            if (array1[i] == array2[i]) matchesFound++;
        }
        return matchesFound;
    }

    private static int[] getRandomIntArray(int length, int from, int to, boolean sort) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (Math.random() * (to + 1 - from) + from);
        }
        if (sort) Arrays.sort(a);
        return a;
    }
}
