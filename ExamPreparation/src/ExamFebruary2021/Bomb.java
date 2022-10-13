package ExamFebruary2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[][] field=new String[size][size];
        String[] commands=scan.nextLine().split(",");
        for (int i = 0; i <size ; i++) {
            String[] line=scan.nextLine().split(" ");
            field[i]=line;
        }
        int sRow=0;
        int sCow=0;
        int bombCounter=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size; j++) {
                if (field[i][j].equals("s")){
                    sRow=i;
                    sCow=j;
                }else if (field[i][j].equals("B")){
                    bombCounter++;
                }
            }
        }
        for (int i = 0; i <commands.length ; i++) {
            String command=commands[i];
            String letter="";
            switch (command){
                case "up":
                    sRow--;
                    if (isInFiled(sRow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("B")){
                            System.out.println("You found a bomb!");
                            field[sRow][sCow]="+";
                            bombCounter--;
                        }
                    }else {
                        sRow++;
                    }
                    break;
                case "down":
                    sRow++;
                    if (isInFiled(sRow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("B")){
                            System.out.println("You found a bomb!");
                            field[sRow][sCow]="+";
                            bombCounter--;
                        }
                    }else {
                        sRow--;
                    }
                    break;
                case "right":
                    sCow++;
                    if (isInFiled(sCow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("B")){
                            System.out.println("You found a bomb!");
                            field[sRow][sCow]="+";
                            bombCounter--;
                        }
                    }else {
                        sCow--;
                    }
                    break;
                case "left":
                    sCow--;
                    if (isInFiled(sCow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("B")){
                            System.out.println("You found a bomb!");
                            field[sRow][sCow]="+";
                            bombCounter--;
                        }
                    }else {
                        sCow++;
                    }
                    break;
            }
            if (letter.equals("e")){
                System.out.printf("END! %d bombs left on the field",bombCounter);
                return;
            }if (bombCounter==0){
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCounter,sRow,sCow);
    }

    private static boolean isInFiled(int n, int size) {
        if (n>=0&&n<=size-1){
            return true;
        }
        return false;
    }
}
