package MultidimensionalArrays_6_exc;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matrix = readMatrix(scan);
        String[] commands = scan.nextLine().split(" ");
        while (!commands[0].equals("END")) {
            if (commands[0].equals("swap") && commands.length == 5) {
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                if (!commands[0].equals("swap")
                        || row1 < 0 || row1 > matrix.length || col1 < 0 || col1 > matrix[row1].length || row2 < 0 || row2 > matrix.length || col2 < 0 || col2 > matrix[row2].length) {
                    System.out.println("Invalid input!");
                } else {

                    String number1 = matrix[row1][col1];
                    String number2 = matrix[row2][col2];
                    matrix[row1][col1] = number2;
                    matrix[row2][col2] = number1;
                    printMatrix(matrix);
                }
            } else {
                System.out.println("Invalid input!");
            }
            commands = scan.nextLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }

    private static String[][] readMatrix(Scanner scan) {
        int row = Integer.parseInt(scan.next());
        int col = Integer.parseInt(scan.next());
        scan.nextLine();
        String[][] matrix = new String[row][col];
        for (int i = 0; i < matrix.length; i++) {
            String[] arr = scan.nextLine().split(" ");
            matrix[i] = arr;
        }
        return matrix;
    }
}
