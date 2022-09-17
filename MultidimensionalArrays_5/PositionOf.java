package MultidimensionalArrays_5;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions=scan.nextLine().split("\\s+");
        int rows=Integer.parseInt(dimensions[0]);
        int cols=Integer.parseInt(dimensions[1]);
        int[][] matrix=new int[rows][cols];
        for (int row = 0; row <matrix.length ; row++) {
            int[] numbers= Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row]=numbers;
        }
        int number=Integer.parseInt(scan.nextLine());
        boolean isTrue=false;
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                if (matrix[row][col]==number){
                    System.out.println(row+" "+col);
                    isTrue=true;
                }
            }
        }
        if (!isTrue){
            System.out.println("not found");
        }

    }
}
