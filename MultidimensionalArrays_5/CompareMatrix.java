package MultidimensionalArrays_5;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scan);
        int[][] secondMatrix = readMatrix(scan);
//        if (Arrays.deepEquals(firstMatrix,secondMatrix)){ TODO същото решение но е от вградената функционалност на джава
//            System.out.println("equal");
//        }else{
//            System.out.println("not equal");
//        }


        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) return false;
        for (int row = 0; row < firstMatrix.length ; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) return false;
            for (int col = 0; col < firstMatrix[row].length ; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) return false;
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scan) {
        String[] dimensions = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }

//    private static void printMatrix(int[][] matrix) {//TODO отпечатване на матрица чреч вложени for each
//        for (int[] arr : matrix) {
//            for (int n : arr) {
//                System.out.println(n + " ");
//            }
//            System.out.println();
//        }
//
//    }

//    private static void printMatrix(int[][] matrix) { //TODO отпечатване на матрица чрез два вложени цикъла
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                System.out.println(matrix[row][col] + " ");
//            }
//            System.out.println();
//        }
//    }
}
