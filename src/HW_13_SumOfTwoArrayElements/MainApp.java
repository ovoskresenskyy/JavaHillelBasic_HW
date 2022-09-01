package HW_13_SumOfTwoArrayElements;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        int[] nums = getRandomIntArray(5, 0, 15, true);
        int sum = 10;

        System.out.println("Sum founded: " + findSum2(nums, sum));
        //System.out.println("Sum founded: " + findSum(nums, sum));
    }

    public static boolean findSum2(int[] nums, int sum) {
        for (int i = 0, j = nums.length - 1; i != j; ) {
            int sumAB = nums[i] + nums[j];

            if (sumAB == sum) {
                return true;
            } else if (sumAB < sum) {
                i++;
            } else {
                if (i != 0) {
                    i--;
                }
                j--;
            }

        }
        return false;
    }

    private static boolean findSum(int[] nums, int sum) {
        for (int i = 0; i < nums.length; i++) {
            int indexDifference = Arrays.binarySearch(nums, sum - nums[i]);
            if (indexDifference != i && indexDifference > 0) {
                return true;
            }
        }
        return false;
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
