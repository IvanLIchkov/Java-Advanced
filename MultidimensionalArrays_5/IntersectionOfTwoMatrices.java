package MultidimensionalArrays_5;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        String[][] firstMatrix = readMatrix(rows, cols, scan);
        String[][] secondMatrix = readMatrix(rows, cols, scan);
        String[][] outputMatrix = intersectingElements(firstMatrix, secondMatrix, rows, cols);
        for (String[] matrix : outputMatrix) {
            for (String s : matrix) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    private static String[][] intersectingElements(String[][] firstMatrix, String[][] secondMatrix, int number1, int number2) {
        String[][] outputMatrix = new String[number1][number2];
        for (int rows = 0; rows < firstMatrix.length; rows++) {
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (!firstMatrix[rows][cols].equals(secondMatrix[rows][cols])) {
                    outputMatrix[rows][cols] = "*";
                } else {
                    outputMatrix[rows][cols] = firstMatrix[rows][cols];
                }
            }
        }
        return outputMatrix;
    }

    private static String[][] readMatrix(int number1, int number2, Scanner scan) {
        int rows = Integer.parseInt(String.valueOf(number1));
        int cols = Integer.parseInt(String.valueOf(number2));
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scan.nextLine().split("\\s+");

            matrix[row] = arr;
        }
        return matrix;
    }
}
