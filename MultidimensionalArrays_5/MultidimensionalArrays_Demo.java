package MultidimensionalArrays_5;

import java.util.Scanner;

public class MultidimensionalArrays_Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix2={
                {13, 42, 55},
                {13, 42, 69},
                {13, 42, 69},
        };//TODO така се инициализира матрица

        System.out.println(matrix2[0][2]);

        int[][] matrix1=new int[3][4];//TODO така също се инициализира матрица но без хардкодене.
        //1 -> prev + 1 .....
        int start=1;
        for (int row = 0; row <3 ; row++) {
            for (int col = 0; col < 4 ; col++) {
                matrix1[row][col] = start;
                start++;
            }
        }
        System.out.println();
    }
}
