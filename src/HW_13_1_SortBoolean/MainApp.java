package HW_13_1_SortBoolean;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        boolean[] a = getRandomBooleanArray(10);
        System.out.println("Not sorted array: " + Arrays.toString(a));
        for (int i = 0, falseMaxIndex = 0; i < a.length; i++) {
            boolean x = a[i];

            if (!x) {
                boolean temp = a[falseMaxIndex];
                a[falseMaxIndex] = x;
                a[i] = temp;
                falseMaxIndex++;
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    private static boolean[] getRandomBooleanArray(int length) {
        boolean[] a = new boolean[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (Math.random() * 2) == 1 ? true : false;
        }
        return a;
    }

}
