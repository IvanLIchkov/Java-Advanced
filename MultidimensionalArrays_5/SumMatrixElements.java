package MultidimensionalArrays_5;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix=matrixReader(scan);
        int sum=0;
        for (int[] number : matrix) {
            for (int n : number) {
                sum+=n;
            }
        }
        System.out.println(sum);

    }

    private static int[][] matrixReader(Scanner scan) {
        String[] sizes= scan.nextLine().split(", ");
        int rows=Integer.parseInt(sizes[0]);
        int cols=Integer.parseInt(sizes[1]);
        int[][] matrix=new int[rows][cols];
        for (int row = 0; row <rows ; row++) {
                int[] arr=Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
                matrix[row]=arr;
        }
        System.out.println(rows);
        System.out.println(cols);
        return matrix;
    }
}
