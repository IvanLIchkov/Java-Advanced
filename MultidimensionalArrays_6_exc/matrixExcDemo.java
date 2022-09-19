package MultidimensionalArrays_6_exc;

import java.util.Arrays;
import java.util.Scanner;

public class matrixExcDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = 3;
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] rowInput = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowInput;
        }

        for (int row = 0; row <rows; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
}
