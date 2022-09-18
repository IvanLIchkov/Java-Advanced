package MultidimensionalArrays_6_exc;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensionsAndPattern = scan.nextLine().split(", ");
        int dimension = Integer.parseInt(dimensionsAndPattern[0]);
        int[][] matrix = new int[dimension][dimension];
        if (dimensionsAndPattern[1].equals("A")) {
            patternA(matrix);
        } else {
            patternB(matrix);
        }
    }

    private static void patternB(int[][] matrix) {
        int n = 1;
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (counter % 2 == 0) {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = n;
                    n++;
                }
                counter--;
            } else {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = n;
                    n++;
                }
                counter++;
            }
        }
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void patternA(int[][] matrix) {
        int n = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = n;
                n++;
            }
        }
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
