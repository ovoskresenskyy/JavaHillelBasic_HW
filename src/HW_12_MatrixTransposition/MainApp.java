package HW_12_MatrixTransposition;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Enter the matrix width.");
//        int matrixWidth = scan.nextInt();
//
//        System.out.println("Enter the matrix height.");
//        int matrixHeight = scan.nextInt();
//
//        int[][] matrix = new int[matrixHeight][matrixWidth];
//        for (int i = 0; i < matrixHeight; i++) {
//            matrix[i] = getRandomIntArray(matrixWidth, 0, (matrixWidth + matrixHeight) * 2);
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        System.out.println();

        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrixTransposition = new int[3][3];

        //int[][] matrixTransposition = new int[matrixWidth][matrixHeight];
//        for (int i = 0; i < matrixWidth; i++) {
//            for (int j = 0; j < matrixHeight; j++) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixTransposition[i][j] = matrix[j][i];
            }
            System.out.println(Arrays.toString(matrixTransposition[i]));
        }
    }

    private static int[] getRandomIntArray(int length, int from, int to) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (Math.random() * (to + 1 - from) + from);
        }
        return a;
    }
}
