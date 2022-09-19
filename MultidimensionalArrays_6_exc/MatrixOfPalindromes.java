package MultidimensionalArrays_6_exc;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int r = Integer.parseInt(scan.next());
        int c = Integer.parseInt(scan.next());
        String[][] palindromeMatrix = new String[r][c];
        for (int row = 0; row < palindromeMatrix.length; row++) {
            palindromeString(row, palindromeMatrix);

        }
        for (String[] row : palindromeMatrix) {
            for (String palindrome : row) {
                System.out.print(palindrome + " ");
            }
            System.out.println();
        }

    }

    private static void palindromeString(int row, String[][] palindromeMatrix) {
        StringBuilder palindrome = new StringBuilder();
        for (int col = 0; col < palindromeMatrix[row].length; col++) {
            char firstLetter = (char) (97 + row);
            char secondLetter = (char) (97 + col + row);
            char thirdLetter = (char) (97 + row);
            palindrome.append(firstLetter);
            palindrome.append(secondLetter);
            palindrome.append(thirdLetter);
            palindromeMatrix[row][col] = String.valueOf(palindrome);
            palindrome.delete(0, palindrome.length());
        }
    }
}
