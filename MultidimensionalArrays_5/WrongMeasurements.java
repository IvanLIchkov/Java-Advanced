package MultidimensionalArrays_5;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows=Integer.parseInt(scan.nextLine());
        int[][] matrix=new int[rows][];
        for (int row = 0; row <rows ; row++) {
            int[] arr= Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row]=arr;
        }
        int[][] outputMatrix=new int[rows][matrix[0].length];
        int[] indexOfWrongValue=Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongNumber=matrix[indexOfWrongValue[0]][indexOfWrongValue[1]];
        int newNumber=0;
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                if (matrix[row][col] == wrongNumber){
                    if (row-1>=0){
                        if (matrix[row-1][col]!=wrongNumber){
                            newNumber+=matrix[row-1][col];
                        }
                    }if (col+1<= matrix[row].length-1 ){
                        if (matrix[row][col+1]!=wrongNumber){
                            newNumber+=matrix[row][col+1];
                        }
                    }
                    if (row+1<=matrix.length-1){
                        if (matrix[row+1][col]!=wrongNumber){
                            newNumber+=matrix[row+1][col];
                        }
                    }if (col-1>=0){
                        if (matrix[row][col-1]!=wrongNumber){
                            newNumber+=matrix[row][col-1];
                        }
                    }
                    outputMatrix[row][col]=newNumber;
                    newNumber=0;
                }else{
                    int number=matrix[row][col];
                    outputMatrix[row][col]= number;
                }
            }
        }
        for (int[] row : outputMatrix) {
            for (int n : row) {
                System.out.print(n+" ");
            }
            System.out.println();
        }


    }
}
