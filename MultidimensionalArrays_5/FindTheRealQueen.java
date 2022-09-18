package MultidimensionalArrays_5;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] chessBoard=new String[8][8];
        for (int row = 0; row <chessBoard.length ; row++) {
                String[] symbols=scan.nextLine().split("\\s+");
                chessBoard[row]=symbols;

        }
        boolean isQueen=false;
        for (int row = 0; row <chessBoard.length ; row++) {
            for (int col = 0; col <chessBoard[row].length ; col++) {
                if (chessBoard[row][col].equals("q")){
                    int index=0;
                    while (index<=chessBoard.length-1){
                        if (chessBoard[index][index].equals("q")&&row!=index &&col!=index){
                            break;
                        }
                        isQueen=true;
                        index++;
                    }
                }
            }
        }
    }
}
