package MultidimensionalArrays_6_exc;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix=readMatrix(scan);
        int sumOfDiagonals=0;
        for (int row = 0; row < matrix.length ; row++) {
           sumOfDiagonals+=matrix[row][row];
           sumOfDiagonals-=matrix[row][matrix.length-1-row];
        }
//        int col=matrix.length-1;
//        for (int row = 0; row < matrix.length ; row++) {
//                sumOfDiagonals-=matrix[row][col];
//                col--;
//
//        }
        System.out.println(Math.abs(sumOfDiagonals));
    }

    private static int[][] readMatrix(Scanner scan) {
        int dimension=Integer.parseInt(scan.nextLine());
        int[][] matrix=new int[dimension][];
        for (int row = 0; row <dimension ; row++) {
            int[] arr= Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row]=arr;
        }
        return matrix;
    }
}
