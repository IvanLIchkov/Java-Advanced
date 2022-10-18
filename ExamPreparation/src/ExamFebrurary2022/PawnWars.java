package ExamFebrurary2022;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] table = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] line = scan.nextLine().split("");
            table[i] = line;
        }
        int wRow = -1;
        int wCow = -1;
        int bRow = -1;
        int bCow = -1;
        for (int row = 0; row < 8; row++) {
            for (int cow = 0; cow < 8; cow++) {
                if (table[row][cow].equals("b")) {
                    bRow = row;
                    bCow = cow;
                } else if (table[row][cow].equals("w")) {
                    wRow = row;
                    wCow = cow;
                }
            }
        }

        for (int i = 1; i < 16; i++) {
            boolean someoneWin=false;
            if (i % 2 != 0) {
                if (whiteCheck(wRow, wCow, bRow, bCow)){
                    someoneWin=true;
                }
                wRow--;
            } else {
                if (blackCheck(wRow, wCow, bRow, bCow)){
                    someoneWin=true;

                }
                bRow++;
            }
            if (someoneWin){
                return;
            }
        }
    }

    private static boolean whiteCheck(int wRow, int wCow, int bRow, int bCow) {
        if (wRow == bRow+1 && wCow - 1 == bCow || wRow == bRow+1 && wCow + 1 == bCow) {
            System.out.printf("Game over! White capture on %s%d.", Character.toString(97 + bCow), 8 - bRow);
            return true;
        } else if (wRow == 0) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s%d.", Character.toString(97 + wCow), 8);
            return true;
        }
        return false;
    }

    private static boolean blackCheck(int wRow, int wCow, int bRow, int bCow) {
        if (bRow == wRow-1 && bCow - 1 == wCow || bRow == wRow-1 && bCow + 1 == wCow) {
            System.out.printf("Game over! Black capture on %s%d.", Character.toString(97 + wCow), 8 - wRow);
            return true;
        } else if (bRow == 7) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s%d.", Character.toString(97 + bCow), 1);
            return true;
        }
        return false;
    }
}
