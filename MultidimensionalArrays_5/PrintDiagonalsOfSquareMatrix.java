package MultidimensionalArrays_5;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimension = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[dimension][dimension];
        int[][] outputMatrix = new int[2][dimension];
        for (int row = 0; row < dimension; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
        int n = 0;
        while (n <= matrix.length - 1) {
            outputMatrix[0][n] = matrix[n][n];
            outputMatrix[1][n] = matrix[matrix.length - 1 - n][n];
            n++;
        }
        for (int[] row : outputMatrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();

        }

    }
}
