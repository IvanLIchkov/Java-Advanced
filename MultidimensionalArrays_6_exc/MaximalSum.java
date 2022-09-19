package MultidimensionalArrays_6_exc;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = matrixReader(scan, rows, cols);
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[][] result = new int[3][3];
        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row][col + 2]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1]
                        + matrix[row + 1][col + 2]
                        + matrix[row + 2][col]
                        + matrix[row + 2][col + 1]
                        + matrix[row + 2][col + 2];
                if (maxSum < sum) {
                    maxSum = sum;
                    result = new int[][]{
                            {matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
                            {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}
                    };
                }
            }
        }
        System.out.println("Sum = "+maxSum);
        for (int[] row : result) {
            for (int n : row) {
                System.out.print(n+" ");
            }
            System.out.println();
        }

    }

    private static int[][] matrixReader(Scanner scan, int row, int col) {
        int[][] matrix=new int[row][col];
        for (int rows = 0; rows < row; rows++) {
            int[] arr= Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[rows]=arr;
        }
        return matrix;
    }
}
