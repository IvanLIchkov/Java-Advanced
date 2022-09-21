package MultidimensionalArrays_6_exc;

import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows=Integer.parseInt(scan.next());
        int cols=Integer.parseInt(scan.next());
        scan.nextLine();
        int[][] matrix=new int[rows][cols];
        int i=1;
        for (int row = 0; row <rows ; row++) {
            for (int col = 0; col <cols ; col++) {
                matrix[row][col]=i;
                i++;
            }
        }
        String[] input=scan.nextLine().split(" ");
        while (!input[0].equals("Nuke")){
            int row=Integer.parseInt(input[0]);
            int col=Integer.parseInt(input[1]);
            int radius=Integer.parseInt(input[2]);

            int start=Math.max(0, row-radius);
            int end = Math.min(matrix.length-1, row+radius);

            for (int f = start; f<=end ; f++) {
                if (isValid(f, col,matrix) && f!=row){
                 matrix= removeElement(f, col, matrix);
                }
            }


            input=scan.nextLine().split(" ");
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }

    private static int[][] removeElement(int row, int col, int[][] matrix) {
        int rowSize=matrix[row].length-1;

        if (rowSize>0){
            int elementToRemove = matrix[row][col];
            int index=0;
            int[] arr=new int[rowSize];
            for (int i = 0; i <matrix[row].length ; i++) {
                int currentNum=matrix[row][i];
                if (currentNum!=elementToRemove){
                    arr[index++]=currentNum;
                }
            }
            matrix[row]=arr;
        }else{
            int[][] newMatrix=new int[matrix.length-1][];
            boolean finished=false;

            int rowMatrix=0;
            int newMatrixRow=0;


            int elementToRemove=matrix[row][col];
            while (!finished){
                int matrixRowSize=matrix[rowMatrix].length;
                if (matrixRowSize>1 || matrix[rowMatrix][col]!=elementToRemove){
                    newMatrix[newMatrixRow]=matrix[rowMatrix];
                    newMatrixRow++;
                }
                rowMatrix++;
                if (rowMatrix>=matrix.length){
                    finished=true;
                }
            }
            matrix=newMatrix;
        }
        return matrix;
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        return (row >=0) && (row <matrix.length)&&
                (col>=0)&&(col<matrix[row].length);
    }
}
