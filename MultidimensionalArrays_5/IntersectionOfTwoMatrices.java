package MultidimensionalArrays_5;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] firstMatrix = readMatrix(rows, cols, scan);
        char[][] secondMatrix = readMatrix(rows, cols, scan);
        char[][] outputMatrix = intersectingElements(firstMatrix, secondMatrix, rows, cols);
        for (char[] matrix : outputMatrix) {
            for (char s : matrix) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    private static char[][] intersectingElements(char[][] firstMatrix, char[][] secondMatrix, int number1, int number2) {
        char[][] outputMatrix = new char[number1][number2];
        for (int rows = 0; rows < firstMatrix.length; rows++) {
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (firstMatrix[rows][cols]!=secondMatrix[rows][cols]) {
                    outputMatrix[rows][cols] = '*';
                } else {
                    outputMatrix[rows][cols] = firstMatrix[rows][cols];
                }
            }
        }
        return outputMatrix;
    }

    private static char[][] readMatrix(int number1, int number2, Scanner scan) {
        int rows = Integer.parseInt(String.valueOf(number1));
        int cols = Integer.parseInt(String.valueOf(number2));
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] arr = scan.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();

            matrix[row] = arr;
        }
        return matrix;
    }
}
