package MultidimensionalArrays_6_exc;

import java.util.Scanner;

public class StringMatrixRotationMySolution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine().replace("(", " ");
        command = command.replace(")", " ");
        String[] extractDegree = command.split(" ");
        int degrees = Integer.parseInt(extractDegree[1]);
        String stringInput = scan.nextLine();
        String input = "";
        while (!stringInput.equals("END")) {
            input += stringInput + " ";
            stringInput = scan.nextLine();
        }
        String[] words = input.split(" ");
        char[][] matrix0 = new char[words.length][];
        int longestWord = 0;
        for (int i = 0; i < words.length; i++) {
            if (longestWord < words[i].length()) {
                longestWord = words[i].length();
            }
        }
        int spaces = 0;
        for (int i = 0; i < words.length; i++) {
            spaces = longestWord - words[i].length();
            for (int j = 0; j < spaces; j++) {
                words[i] += " ";
            }
            char[] wordsAsCharArr = words[i].toCharArray();

            matrix0[i] = wordsAsCharArr;
        }
        char[][] matrix1 = new char[longestWord][matrix0.length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                matrix1[row][col] = matrix0[matrix0.length - col - 1][row];
            }
        }
        char[][] matrix2 = new char[matrix0.length][longestWord];
        for (int row = 0; row < matrix0.length; row++) {
            for (int col = 0; col < matrix0[row].length; col++) {
                matrix2[row][col] = matrix0[matrix0.length - row - 1][matrix0[row].length - col - 1];
            }
        }
        char[][] matrix3 = new char[longestWord][matrix0.length];
        for (int row = 0; row < matrix3.length; row++) {
            for (int col = 0; col < matrix3[row].length; col++) {
                matrix3[row][col] = matrix0[col][matrix3.length - 1 - row];
            }
        }

        int angleOfRotation=degrees%360;
        if (angleOfRotation == 0) {
            printMatrix(matrix0);
        } else if (angleOfRotation == 90) {
            printMatrix(matrix1);
        } else if (angleOfRotation == 180) {
            printMatrix(matrix2);
        } else if (angleOfRotation == 270) {
            printMatrix(matrix3);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();

        }

    }
}
